package com.ruoyi.project.awc.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.entity.AwcPrize;
import com.ruoyi.project.awc.entity.PhotoInfo;
import com.ruoyi.project.awc.mapper.PhotoInfoMapper;
import com.ruoyi.project.awc.service.applyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.ReturnType;

import java.util.List;

@Service
public class applyServiceImpl extends ServiceImpl<PhotoInfoMapper, PhotoInfo> implements applyService {

    private PhotoInfo photoInfo;
    @Autowired
    private PhotoInfoMapper photoInfoMapper;

    private AwcPrize awcPrize;


    /**
     * @param
     * @return
     */
    @Override
    public List<PhotoInfo> getMyPhotoInfo() {
        return photoInfoMapper.selectList(null);

    }

    /**
     * 获取赛事标题
     * @return
     */
    @Override
    public PhotoInfo showTital() {
        return photoInfoMapper.selectById(photoInfo.getPhotoMatchid());
    }

    /**
     * 查询全部记录
     *
     * @return
     */
    @Override
    public PhotoInfo getMyApplyInfo() {

        return photoInfoMapper.selectById(photoInfo.getPhotoMatchid());
    }


    /**
     * 获奖信息
     *
     * @return
     */
    @Override
    public PhotoInfo getPrizeInfo() {
        return photoInfoMapper.selectById(awcPrize.getPrizeMatchid());
    }

    /**
     * 取消报名
     */
    @Override
    public void applyCancle() {
        //弹窗
    }


}
