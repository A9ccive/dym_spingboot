package com.ruoyi.project.awc.bo.userbo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "报名信息", description = "报名信息-参数校验")
public class ApplyParam {


    @ApiModelProperty(value = "作者姓名")
    private String photoZzname;

    @ApiModelProperty(value = "微信号")
    @JsonIgnore
    private String photoWxid;

    @ApiModelProperty(value = "手机号")
    @JsonIgnore
    private Long photoPhone;

    @ApiModelProperty(value = "性别（男，女）")
    @JsonIgnore
    private String photoSex;


    @ApiModelProperty(value = "身份证号")
    @TableField("photo_idCard")
    @JsonIgnore
    private String photoIdcard;

    @ApiModelProperty(value = "所在省市")
    private String photoPos;

    @ApiModelProperty(value = "作品名称")
    private String photoZpname;

    @ApiModelProperty(value = "作品类型")
    private Integer photoType;

    @ApiModelProperty(value = "作品说明")
    private String photoDesc;

    @ApiModelProperty(value = "作品百度地址")
    private String photoBaiduurl;

    @ApiModelProperty(value = "作品封面地址")
    private String photoFmurl;





}
