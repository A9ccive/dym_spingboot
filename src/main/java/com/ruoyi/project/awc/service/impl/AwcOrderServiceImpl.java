package com.ruoyi.project.awc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.project.awc.dto.goods.GoodsDto;
import com.ruoyi.project.awc.entity.AwcGoods;
import com.ruoyi.project.awc.entity.AwcOrder;

import com.ruoyi.project.awc.mapper.AwcOrderMapper;

import com.ruoyi.project.awc.service.AwcOrderService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AwcOrderServiceImpl extends ServiceImpl<AwcOrderMapper, AwcOrder> implements AwcOrderService {
    private AwcGoods awcGoods;
    @Autowired
    private AwcOrderMapper awcOrderMapper;
    @Override
    public AwcOrder getOrderInfo(Object id) {
        AwcOrder awcOrder = awcOrderMapper.selectById((Serializable) id);
        Assert.notNull(awcOrder,"订单详情不存在!");
        return awcOrder;
    }
}
