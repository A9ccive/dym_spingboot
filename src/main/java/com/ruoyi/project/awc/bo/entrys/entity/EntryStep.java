package com.ruoyi.project.awc.bo.entrys.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 *     参赛步骤
 * </p>
 * @author sunhongwei
 * @since 2021-03-31
 */
@Data
@ApiModel(description="参赛步骤")
public class EntryStep {
    @ApiModelProperty(value = "步骤信息")
    private List<StepInfo> stepInfos = Collections.emptyList();
    @ApiModelProperty(value = "当前事件")
    private String currentStepEvent;
    @ApiModelProperty(value = "下级事件")
    private String nextStepEvent;
    @ApiModelProperty(value = "是否可以完成参赛")
    private boolean isCanEntrys = false;
    @ApiModelProperty(value = "参赛id")
    private Long entrysId;
    @ApiModelProperty(value = "赛事id")
    private Integer contestId;
}
