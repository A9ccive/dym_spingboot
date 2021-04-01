package com.ruoyi.project.awc.bo.entrys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * 参赛步骤情
 * @author sunghongwei
 * @since 2021-03-31
 */
@Data
@Builder
@ApiModel(description="参赛步骤详情")
public class StepDetail {
    @ApiModelProperty(value = "步骤详情任务id")
    private String stepTaskId;
    @ApiModelProperty(value = "步骤详情标题")
    private String stepTitle;
    @ApiModelProperty(value = "步骤详情描述")
    private String stepDesc;
    @ApiModelProperty(value = "步骤详情值")
    private Map<String, String> stepBtn;
    @ApiModelProperty(value = "步骤详情链接")
    private String extUrl;
    @ApiModelProperty(value = "步骤详情是否完成")
    private boolean isFinished;
}
