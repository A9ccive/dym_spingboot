package com.ruoyi.project.awc.bo.event;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 历史赛事页面参数校验
 */
@Data
@ApiModel(value = "历史赛事页面", description = "历史赛事页面参数校验")
public class EventHisParam {

    @ApiModelProperty(value = "赛事标题")
    private String title;

}
