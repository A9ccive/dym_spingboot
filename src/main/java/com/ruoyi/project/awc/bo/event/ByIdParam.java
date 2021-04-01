package com.ruoyi.project.awc.bo.event;

import com.ruoyi.common.utils.check.IsItNecessary;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 参数校验 ：id
 */
@lombok.Getter
@lombok.Setter
@ApiModel(value = "id", description = "参数校验 ：id")
public class ByIdParam<T> {

    @ApiModelProperty(value = "id")
    @IsItNecessary(key = true)
    private T id;


    public ByIdParam() {
    }

    public ByIdParam(T id) {
        this.id = id;
    }
}
