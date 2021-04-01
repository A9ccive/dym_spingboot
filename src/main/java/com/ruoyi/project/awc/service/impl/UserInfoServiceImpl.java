package com.ruoyi.project.awc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.framework.config.CaptchaConfig;
import com.ruoyi.project.awc.entity.AwcUser;
import com.ruoyi.project.awc.mapper.AwcUserMapper;
import com.ruoyi.project.awc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 个人信息 服务实现类
 * </p>
 *
 * @author
 * @since 2021-03-25
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<AwcUserMapper, AwcUser> implements UserInfoService {

    private AwcUserMapper awcUserMapper;
    @Autowired
    private CaptchaConfig captchaConfig;

    private RedisTemplate<String,Object> redisTemplate;

    /**
     *获取全部
     * @return
     * public IPage<PhotoInfo> eventHomePage(Page<PhotoInfo> page, EventSyParam eventSyParam)
     */
    @Override
    public List<AwcUser> findAll() {
        return awcUserMapper.selectByMap(null);
    }

    /**
     * 增加
     * @param awcUser
     */
    @Override
    public void add(AwcUser awcUser) {
        awcUserMapper.insert(awcUser);
    }

    /**
     * 更新
     * @param awcUser
     */
    @Override
    public void update(AwcUser awcUser) {
        awcUserMapper.updateById(awcUser);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void delete(Long[] ids) {
        for (Long id : ids) {
            awcUserMapper.deleteById(id);
        }

    }

    /**
     * 根据id获取
     * @param id
     * @return
     */
    @Override
    public AwcUser findUserByID(String id) {
        return awcUserMapper.selectById(id);
    }


    /**
     *
     * @param phone
     */
    @Override
    public void createSmsCode(String phone) {
        String code =Math.random()*1000000+"";
        //存入缓存
        redisTemplate.boundHashOps("smscode").put(phone,code);
        System.out.println(code);
    }

    /**
     *
     * @param phone
     * @param code
     * @return
     */
    @Override
    public boolean checkSmsCode(String phone, String code) {
        String sysCode= (String) redisTemplate.boundHashOps("smscode").get(phone);
        if(null==sysCode){
            return false;
        }
        if(!sysCode.equals(code)){
            return false;
        }
        return true;
    }



}
