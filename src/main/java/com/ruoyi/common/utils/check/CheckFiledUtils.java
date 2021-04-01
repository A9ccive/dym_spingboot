package com.ruoyi.common.utils.check;


import com.ruoyi.common.exception.ParamException;
import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;

/**
 * 校验类属性是否有值
 * @author
 * created
 */
public class CheckFiledUtils {

    public static void  isFieldNull(Object obj) throws Exception{
        Class stuCla = (Class) obj.getClass();// 得到类对象
        Field[] fs = stuCla.getDeclaredFields();//得到属性集合
        boolean flag = true;
        boolean r =false;
        StringBuilder message = new StringBuilder();
        message.append("参数属性：");
        StringBuilder errorMsg = new StringBuilder();
        for (Field f : fs) { //遍历属性
            f.setAccessible(true); // 设置属性是可以访问的(私有的也可以)
            Object val = f.get(obj);// 得到此属性的值

            IsItNecessary t = (IsItNecessary) f.getAnnotation(IsItNecessary.class);

            if(t != null) {
                r = t.key();

                if (r == false) {
                    continue;
                }

                if (val != null && !String.valueOf(val).isEmpty()) {
                    System.out.println("属性" + f.getName() + "值为：" + val);
                } else {
                    errorMsg.append(f.getName()+" " );
                    System.out.println("属性" + f.getName() + "，不能为空");
                }
            }
        }
        message.append(errorMsg);
        message.append(":不能为空！");
        if(StringUtils.isNotBlank(errorMsg.toString())){
            throw new ParamException(message.toString(),0000L);
        }
    }



}
