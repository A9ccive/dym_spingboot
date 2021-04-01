package com.ruoyi.project.awc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.project.awc.entity.ContestTask;
import com.ruoyi.project.awc.entity.PhotoInfo;
import com.ruoyi.project.awc.mapper.PhotoInfoMapper;
import com.ruoyi.project.awc.service.PhotoInfoService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author
 * @since 2021-03-25
 */
@Service

public class PhotoInfoServiceImpl extends ServiceImpl<PhotoInfoMapper, PhotoInfo> implements PhotoInfoService {

    @Override
    public PhotoInfo getStateByContestIdAndUserId(Integer photoUserid, Integer photoMatchid) {
        LambdaQueryWrapper<ContestTask> queryWrapper = new LambdaQueryWrapper<>();
        return null;
    }

    @Override
    public PhotoInfo getStateDetailById(Long id) {
        LambdaQueryWrapper<ContestTask> queryWrapper = new LambdaQueryWrapper<>();
        return null;
    }
}
