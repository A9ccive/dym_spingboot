package com.ruoyi.project.awc.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.awc.entity.AwcUser;

import java.util.List;

/**
 * <p>
 * 个人信息 服务类
 * </p>
 *
 * @author
 * @since 2021-03-25
 */
public interface UserInfoService extends IService<AwcUser> {

    /**
     * 返回列表
     *
     * @return
     */
     List<AwcUser> findAll();

//    @Override
//    IPage<AwcUser> page(IPage<AwcUser> page, Wrapper<AwcUser> queryWrapper);
  //IPage<PhotoInfo> eventHomePage(Page<PhotoInfo> page, EventSyParam eventSyParam);

    /**
     * 增加
     */
     void add(AwcUser awcUser);

    /**
     * 修改
     */
     void update(AwcUser awcUser);

    /**
     * 删除
     */
     void delete(Long[] ids);
    //IPage<PhotoInfo> eventHomePage(Page<PhotoInfo> page, EventSyParam eventSyParam);

    /**
     * 查询
     */
     AwcUser findUserByID(String id);

    /**
     * 生成短信验证码
     *
     * @return
     */
  void createSmsCode(String phone);

    /**
     * 判断验证码
     *
     * @return
     */
     boolean checkSmsCode(String phone, String code);
}
