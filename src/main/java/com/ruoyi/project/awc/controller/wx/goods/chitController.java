package com.ruoyi.project.awc.controller.wx.goods;


import com.ruoyi.common.utils.Arith;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.entity.AwcAnswer;
import com.ruoyi.project.awc.entity.AwcChit;
import com.ruoyi.project.awc.service.AwcChitService;
import com.ruoyi.project.awc.service.impl.AwcChitServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/chit")
@Api(value = "电子券")
public class chitController {
    @Autowired
    private AwcChitService awcChitService;

    private AwcChit awcChit;

    private AwcAnswer awcAnswer;

    private Arith arith;


    @ApiOperation("根据id获取电子券信息")
    @RequestMapping("/showChit")
    public AjaxResult showChit(Integer id) {
        id=awcChit.getChitUserid();
        try {
            awcChitService.findByUserId(id);
            return AjaxResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     *
     * @return
     */
//      提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
//      定精度，以后的数字四舍五入。
//      @param v1 被除数
//      @param v2 除数
//      @param scale 表示表示需要精确到小数点以后几位。
//      @return 两个参数的商

    @ApiOperation("得到电子券")
    @RequestMapping("/getChit")
    public AjaxResult getChit(){
//        //正确率
//        Double  correct=  arith.div(v1,v2,4);
//        if (correct>0.0085)
//        {
//
//        }else
//        {
//            return AjaxResult.error();
//        }

        return null;
    }

    @ApiOperation("使用电子券")
    @RequestMapping("/useChit")
    public AjaxResult useChit(){

    //    return awcChitService.delete();

        return null;
    }







}
