package com.ruoyi.project.awc.bo.questionaire;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.awc.entity.QuestionnaireInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@ApiModel(description="问卷信息")
public class Quetsionaire {
    @ApiModelProperty(value = "问卷名称")
    private String qtnName;
    @ApiModelProperty(value = "问卷版本")
    private int qtnVersion;
    @ApiModelProperty(value = "问卷id")
    private Long qtnId;
    @ApiModelProperty(value = "问卷条目")
    private List<QuestionItem> questionItems;
    public static Quetsionaire Build(QuestionnaireInfo questionnaireInfo) {
        Quetsionaire quetsionaire = new Quetsionaire();
        quetsionaire.setQtnName(questionnaireInfo.getQtnName());
        quetsionaire.setQtnId(questionnaireInfo.getQtnId());
        quetsionaire.setQtnVersion(questionnaireInfo.getQtnVersion());
        quetsionaire.setQuestionItems(
                JSONArray.parseArray(
                        questionnaireInfo.getQtnQuestions(), JSONObject.class).stream().map( json -> {
                            return QuestionItem.builder()
                                    .options(json.getJSONArray("option").toJavaList(String.class))
                                    .title(json.getString("title"))
                                    .sort((json.getInteger("store").intValue()))
                                    .build();
                }).sorted(Comparator.comparingInt(QuestionItem::getSort))
                        .collect(Collectors.toList()));
        return quetsionaire;
    }

}
