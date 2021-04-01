package com.ruoyi.project.awc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.awc.dto.goods.GoodsDto;
import com.ruoyi.project.awc.entity.AwcOrder;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author
 * @since 2021-03-25
 */
public interface AwcOrderService extends IService<AwcOrder> {
    /**
     * 获取订单详情
     * @return
     */
    AwcOrder getOrderInfo(Object id);
}

