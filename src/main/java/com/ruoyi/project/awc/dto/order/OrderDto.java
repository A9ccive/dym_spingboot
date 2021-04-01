package com.ruoyi.project.awc.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.project.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 订单详情信息
 * </p>
 *
 * @author zhagnyong
 * @since 2021-03-30
 */
@Data
@ApiModel(value="订单详情", description="订单详情信息")
public class OrderDto extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品文本
     */
    private String goodsText;
    /**
     * 商品运费
     */
    private String goodsFreight;
}