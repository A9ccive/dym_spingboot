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
 * 参赛任务进度关联表
 * </p>
 *
 * @author sunhongwei
 * @since 2021-03-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("contest_task_done")
@ApiModel(value="ContestTaskDone对象", description="参赛任务进度关联表")
public class ContestTaskDone extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参赛和任务关联id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "任务id")
    private Long taskId;

    @ApiModelProperty(value = "参赛id")
    private Long photoId;

    @ApiModelProperty(value = "是否完成该任务(1完成，0未完成)")
    private Integer taskStatus;

    @ApiModelProperty(value = "备用字段1")
    private String remark1;

    @ApiModelProperty(value = "备用字段2")
    private String remark2;

    @ApiModelProperty(value = "备用字段3")
    private String remark3;


}
