package com.ruoyi.project.awc.bo.userbo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "个人信息", description = "个人信息-参数校验")

public class UserInfoParam {

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "微信开放id")
    private String userOpenid;

    @ApiModelProperty(value = "微信号")
    private String userWxid;

    @ApiModelProperty(value = "手机号")
    private Long userPhone;

    @ApiModelProperty(value = "性别（1男，2女）")
    private Integer userSex;

    @ApiModelProperty(value = "身份证号")
    private String userIdcard;

    @ApiModelProperty(value = "所在省市")
    private String userLocal;

}
