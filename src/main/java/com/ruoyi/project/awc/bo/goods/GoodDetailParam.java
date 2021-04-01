package com.ruoyi.project.awc.bo.goods;

import com.ruoyi.common.utils.check.IsItNecessary;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 参数校验 ：id
 */
@lombok.Getter
@lombok.Setter
@ApiModel(value = "id", description = "参数校验 ：id")
public class GoodDetailParam<T> {

    @ApiModelProperty(value = "id")
    @IsItNecessary(key = true)
    private T id;

    @ApiModelProperty(value = "是否申请检测")
    private Boolean isCheck = false;


    public GoodDetailParam() {
    }

    public GoodDetailParam(T id) {
        this.id = id;
    }
}
