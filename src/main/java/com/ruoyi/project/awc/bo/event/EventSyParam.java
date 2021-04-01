package com.ruoyi.project.awc.bo.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruoyi.common.utils.check.IsItNecessary;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *  参赛作品or优秀作品页面-参数校验
 */
@Data
@ApiModel(value = "参赛作品or优秀作品", description = "参赛作品or优秀作品页面-参数校验")
public class EventSyParam {

    @ApiModelProperty(value = "作品名称")
    private String photoZpName;

    @ApiModelProperty(value = "作者")
    private String photoZzName;

    @IsItNecessary(key =true)
    @ApiModelProperty(value = "作品(页面选择)：1.优秀作品页面 2.参赛作品页面")
    @JsonProperty
    private Integer pType;

    @IsItNecessary(key =true)
    @ApiModelProperty(value = "作品类型(对应字典表)：视频作品/平面作品/实物设计/区域作品/在线课程/有奖问答")
    private Integer photoType;


}
