package com.ruoyi.project.awc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 商品订单表
 * </p>
 *
 * @author
 * @since 2021-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("awc_order")
@ApiModel(value="AwcOrder对象", description="商品订单表")
public class AwcOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "收货人")
    private String consignee;

    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "收货地址")
    private String adress;

    @ApiModelProperty(value = "数量")
    private Integer count;

    @ApiModelProperty(value = "商品Id")
    private Integer goodsId;

    @ApiModelProperty(value = "商品banner地址")
    @TableField("goods_banner_url")
    private String goodsBannerUrl;

    @ApiModelProperty(value = "购买数量")
    private Integer buyCount;

    @ApiModelProperty(value = "快递方式")
    private String expressWay;

    @ApiModelProperty(value = "快递费用")
    private BigDecimal expressCost;

    @ApiModelProperty(value = "商品单价")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "商品总价")
    private BigDecimal goodsTotalPrice;

    @ApiModelProperty(value = "实付")
    private BigDecimal actuallyPaid;

    @ApiModelProperty(value = "电子券扣减金额")
    @TableField("electronic_coupon_amount")
    private BigDecimal electronicCouponAmount;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品编号")
    private String orderCode;

    @ApiModelProperty(value = "购买规格")
    private String buySpecification;

    @ApiModelProperty(value = "订单状态")
    private String orderStatus;

    @ApiModelProperty(value = "订单物流编号")
    @TableField("order_logistics_code")
    private String orderLogisticsCode;

    @ApiModelProperty(value = "流水号")
    private String serialNumber;

    @ApiModelProperty(value = "用户Id")
    private String userId;

    @ApiModelProperty(value = "订单备注")
    private String orderRemarks;
}
