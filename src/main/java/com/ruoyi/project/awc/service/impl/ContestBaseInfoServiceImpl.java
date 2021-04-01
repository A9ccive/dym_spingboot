package com.ruoyi.project.awc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.project.awc.dto.event.ContestDto;
import com.ruoyi.project.awc.entity.ContestBaseInfo;
import com.ruoyi.project.awc.mapper.ContestBaseInfoMapper;
import com.ruoyi.project.awc.service.ContestBaseInfoService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 赛事基本信息表 服务实现类
 * </p>
 *
 * @author
 * @since 2021-03-29
 */
@Service
public class ContestBaseInfoServiceImpl extends ServiceImpl<ContestBaseInfoMapper, ContestBaseInfo> implements ContestBaseInfoService {

    @Autowired
    private ContestBaseInfoMapper contestBaseInfoMapper;

    /**
     * 历史赛事-详情
     * @param
     * @return
     */
    @Override
    public ContestDto eventHisDetailById(Object id) {
        ContestBaseInfo contestBaseInfo = contestBaseInfoMapper.selectById((Serializable) id);
        Assert.notNull(contestBaseInfo,"当前赛事不存在，请联系管理员！");

        //详情
        ContestDto contestDto =new ContestDto();
        BeanUtils.copy(contestBaseInfo,contestDto);

        return contestDto;

    }

}
