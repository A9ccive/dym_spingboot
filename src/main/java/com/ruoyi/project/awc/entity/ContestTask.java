package com.ruoyi.project.awc.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ruoyi.project.common.BaseEntity;;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 赛事任务
 * </p>
 *
 * @author sunhongwei
 * @since 2021-03-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("contest_task")
@ApiModel(value="ContestTask对象", description="赛事任务")
public class ContestTask extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "赛事任务id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "任务标题")
    private String taskTitle;

    @ApiModelProperty(value = "任务描述")
    private String taskDesc;

    @ApiModelProperty(value = "任务资源地址链接")
    private String taskResourceLink;

    @ApiModelProperty(value = "任务分类")
    private String taskCatalog;

    @ApiModelProperty(value = "任务状态：1有效、0无效")
    private Integer taskStatus;

    @ApiModelProperty(value = "备用字段1")
    private String remark1;

    @ApiModelProperty(value = "备用字段2")
    private String remark2;

    @ApiModelProperty(value = "备用字段3")
    private String remark3;

    @ApiModelProperty(value = "任务是否完成")
    private int isFinished;
}
