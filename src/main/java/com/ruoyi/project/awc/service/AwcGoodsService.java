package com.ruoyi.project.awc.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.awc.dto.goods.GoodsDto;
import com.ruoyi.project.awc.entity.AwcGoods;
import com.ruoyi.project.awc.entity.PhotoInfo;

/**
 * <p>
 * 商品信息表 服务类
 * </p>
 *
 * @author
 * @since 2021-03-26
 */
public interface AwcGoodsService extends IService<AwcGoods> {

    /**
     * 获取商品详情
     * @return
     */
    GoodsDto getGoodsInfo(Object id);

}
