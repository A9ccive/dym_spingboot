package com.ruoyi.project.awc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.project.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

;

/**
 * <p>
 * 调查问卷
 * </p>
 *
 * @author sunhongwei
 * @since 2021-04-01
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("questionnaire_info")
@ApiModel(value="QuestionnaireInfo对象", description="调查问卷")
public class QuestionnaireInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "调研问卷id")
    @TableId(value = "qtn_id", type = IdType.AUTO)
    private Long qtnId;

    @ApiModelProperty(value = "问卷名称")
    private String qtnName;

    @ApiModelProperty(value = "问卷类型:完善信息entrys_per,报名确认entrys_confirm,自检商品购买shopping_qtn")
    private String qtnType;

    @ApiModelProperty(value = "是否完成该任务(1完成，0未完成)")
    private Integer qtnVersion;

    @ApiModelProperty(value = "调查题目")
    private String qtnQuestions;

    @ApiModelProperty(value = "备用字段1")
    private String remark1;

    @ApiModelProperty(value = "备用字段2")
    private String remark2;

    @ApiModelProperty(value = "备用字段3")
    private String remark3;


}
