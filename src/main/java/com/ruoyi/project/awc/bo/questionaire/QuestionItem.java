package com.ruoyi.project.awc.bo.questionaire;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 调研问卷条目
 */
@Data
@Builder
@ApiModel(description="问卷条目")
public class QuestionItem {
    @ApiModelProperty(value = "条目标题")
    private String title;
    @ApiModelProperty(value = "条目选项")
    private List<String> options;
    @ApiModelProperty(value = "条目序列")
    private int sort;
    @ApiModelProperty(value = "条目答案")
    private String answer;
}
