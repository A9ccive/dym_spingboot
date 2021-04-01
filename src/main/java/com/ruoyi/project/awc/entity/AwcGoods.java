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
 * 商品信息表
 * </p>
 *
 * @author
 * @since 2021-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("awc_goods")
@ApiModel(value="AwcGoods对象", description="商品信息表")
public class AwcGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品名称")
    private String goodsName;

    @ApiModelProperty(value = "商品文本")
    private String goodsText;

    @ApiModelProperty(value = "商品库存")
    private Integer goodsRepertory;

    @ApiModelProperty(value = "商品销量")
    private Integer goodsSell;

    @ApiModelProperty(value = "是否新品")
    @TableField("goods_ifNew")
    private Integer goodsIfnew;

    @ApiModelProperty(value = "是否热卖")
    @TableField("goods_ifHot")
    private Integer goodsIfhot;

    @ApiModelProperty(value = "商品规格")
    private Integer goodsSpecs;

    @ApiModelProperty(value = "商品状态")
    private Integer goodsState;

    @ApiModelProperty(value = "单品运费")
    private String goodsFreight;

    @ApiModelProperty(value = "商品分类：普通，检测")
    private Integer goodsClass;

    @ApiModelProperty(value = "商品banner地址1")
    private String goodsBanner1;

    @ApiModelProperty(value = "商品banner地址2")
    private String goodsBanner2;

    @ApiModelProperty(value = "商品banner地址3")
    private String goodsBanner3;

    @ApiModelProperty(value = "商品banner地址4")
    private String goodsBanner4;

    @ApiModelProperty(value = "快递方式：自提，快递")
    private Integer goodsExpress;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal goodsPrice;

    @ApiModelProperty(value = "商品图片")
    private String goodsPicture;


}
