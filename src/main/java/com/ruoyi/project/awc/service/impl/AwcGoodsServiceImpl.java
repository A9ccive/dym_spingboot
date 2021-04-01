package com.ruoyi.project.awc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.project.awc.dto.goods.GoodsDto;
import com.ruoyi.project.awc.entity.AwcGoods;
import com.ruoyi.project.awc.mapper.AwcGoodsMapper;
import com.ruoyi.project.awc.service.AwcGoodsService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 商品信息表 服务实现类
 * </p>
 *
 * @author
 * @since 2021-03-26
 */
@Service
public class AwcGoodsServiceImpl extends ServiceImpl<AwcGoodsMapper, AwcGoods> implements AwcGoodsService {
    private AwcGoods awcGoods;
    @Autowired
    private AwcGoodsMapper awcGoodsMapper;
    @Override
    public GoodsDto getGoodsInfo(Object id) {
        AwcGoods awcGoods = awcGoodsMapper.selectById((Serializable) id);
        Assert.notNull(awcGoods,"当前商品详情不存在，请联系管理员！");

        //详情
        GoodsDto goodsDto =new GoodsDto();
        BeanUtils.copy(awcGoods,goodsDto);

        return goodsDto;
    }
}
