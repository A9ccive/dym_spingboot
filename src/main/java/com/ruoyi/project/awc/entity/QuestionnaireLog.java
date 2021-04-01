package com.ruoyi.project.awc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.project.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

;

/**
 * <p>
 * 调研记录
 * </p>
 *
 * @author sunhongwei
 * @since 2021-04-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("questionnaire_log")
@Builder
@ApiModel(value="QuestionnaireLog对象", description="调研记录")
public class QuestionnaireLog extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "调研问卷id")
    @TableId(value = "qtn_log_id", type = IdType.AUTO)
    private Long qtnLogId;

    @ApiModelProperty(value = "问卷名称")
    private String qtnLogName;

    @ApiModelProperty(value = "问卷类型:完善信息entrys_per,报名确认entrys_confirm,自检商品购买shopping_qtn")
    private String qtnLogType;

    @ApiModelProperty(value = "问卷版本")
    private Integer qtnLogVersion;

    @ApiModelProperty(value = "调查题目")
    private String qtnLogAwnsers;

    @ApiModelProperty(value = "调卷id")
    private Long qtnId;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "赛事id")
    private Integer contestId;

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "备用字段1")
    private String remark1;

    @ApiModelProperty(value = "备用字段2")
    private String remark2;

    @ApiModelProperty(value = "备用字段3")
    private String remark3;

    @ApiModelProperty(value = "参赛id")
    private Long entrysId;


}
