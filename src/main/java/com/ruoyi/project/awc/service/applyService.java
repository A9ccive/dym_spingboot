package com.ruoyi.project.awc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.awc.entity.PhotoInfo;

import java.util.List;

public interface applyService extends IService<PhotoInfo> {


    /**
     * 赛事标题
     */
    public PhotoInfo showTital();


    /**
     * 获取报名信息
     * @return
     */
    public PhotoInfo getMyApplyInfo();


    /**
     * 获取作品信息
     * @return
     */
    public List<PhotoInfo> getMyPhotoInfo();



    /**

     * 获取获奖信息
     *
     * @return
     */
    public PhotoInfo getPrizeInfo();


    /**
     * 取消报名
     */
    public void applyCancle();

}
