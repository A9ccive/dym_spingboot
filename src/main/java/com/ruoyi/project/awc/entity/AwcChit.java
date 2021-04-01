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
import java.time.LocalDate;

/**
 * <p>
 * 用户电子券金额
 * </p>
 *
 * @author
 * @since 2021-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("awc_chit")
@ApiModel(value="AwcChit对象", description="用户电子券金额")
public class AwcChit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    @TableField("chit_userId")
    private Integer chitUserid;

    @ApiModelProperty(value = "余额")
    private BigDecimal chitMoney;

    @ApiModelProperty(value = "总消费")
    @TableField("chit_allOut")
    private BigDecimal chitAllout;

    @ApiModelProperty(value = "总入账")
    @TableField("chit_allIn")
    private BigDecimal chitAllin;

    @ApiModelProperty(value = "最后修改时间")
    @TableField("chit_lastUpdate")
    private LocalDate chitLastupdate;

    @ApiModelProperty(value = "电子券数量")
    private Integer chitNum;


}
