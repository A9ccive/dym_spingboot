package com.ruoyi.project.awc.bo.entrys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 参赛步骤信息
 *
 * @author sunhongwei
 * @since 2021-03-31
 */
@Data
@Builder
@ApiModel(description="参赛步骤信息")
public class StepInfo {
    @ApiModelProperty(value = "步骤名称")
    private String stepName;
    @ApiModelProperty(value = "步骤事件")
    private String stepEvent;
    @ApiModelProperty(value = "步骤是否已完成")
    private boolean isFinished = false;
    @ApiModelProperty(value = "步骤序号")
    private Long sort;
    @ApiModelProperty(value = "步骤详情")
    private List<StepDetail> stepList = Collections.emptyList();
}
