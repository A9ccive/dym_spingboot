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
 * 赛事奖项模板
 * </p>
 *
 * @author
 * @since 2021-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("awc_prize")
@ApiModel(value="AwcPrize对象", description="赛事奖项模板")
public class AwcPrize implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "奖项名称")
    private String prizeName;

    @ApiModelProperty(value = "奖项数量")
    private Integer prizeNum;

    @ApiModelProperty(value = "奖项模板地址")
    @TableField("prize_mbUrl")
    private String prizeMburl;

    @ApiModelProperty(value = "赛事id")
    @TableField("prize_matchId")
    private String prizeMatchid;

    @ApiModelProperty(value = "奖励描述")
    @TableField("prize_prizeIns")
    private String prizePrizeins;

    @ApiModelProperty(value = "电子券金额")
    @TableField("prize_stateMoney")
    private BigDecimal prizeStatemoney;

    @ApiModelProperty(value = "奖项等级")
    private Integer prizeLevel;


}
