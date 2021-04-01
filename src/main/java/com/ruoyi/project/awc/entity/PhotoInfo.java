package com.ruoyi.project.awc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruoyi.project.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 作品报名信息
 * </p>
 *
 * @author sunhongwei
 * @since 2021-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("photo_info")
@ApiModel(value="PhotoInfo对象", description="作品报名信息")
@Builder
public class PhotoInfo extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "作者姓名")
    @TableField("photo_zzName")
    private String photoZzname;

    @ApiModelProperty(value = "作品类型")
    private Integer photoType;

    @ApiModelProperty(value = "作品名称")
    @TableField("photo_zpName")
    private String photoZpname;

    @ApiModelProperty(value = "作品说明")
    private String photoDesc;

    @ApiModelProperty(value = "作品封面地址")
    @TableField("photo_fmUrl")
    private String photoFmurl;

    @ApiModelProperty(value = "作品百度地址")
    @TableField("photo_baiduUrl")
    private String photoBaiduurl;

    @ApiModelProperty(value = "点赞数量")
    private Integer photoGoodNum;

    @ApiModelProperty(value = "是否优秀作品（1优秀，2一般,3……）")
    private Integer photoBetter;

    @ApiModelProperty(value = "获奖说明")
    private String photoInst;

    @ApiModelProperty(value = "是否获奖（1获奖，2未获奖，3……）")
    private Integer photoPrize;

    @ApiModelProperty(value = "报名状态（1已报名，2为未报名，）")
    private Integer photoStatus;

    @ApiModelProperty(value = "报名回执二维码地址")
    @TableField("photo_qrCode")
    private String photoQrcode;

    @ApiModelProperty(value = "参赛码")
    @TableField("photo_csCode")
    private String photoCscode;

    @ApiModelProperty(value = "赛事id")
    @TableField("photo_matchId")
    private Integer photoMatchid;

    @ApiModelProperty(value = "用户id")
    @TableField("photo_userId")
    private Integer photoUserid;

    @ApiModelProperty(value = "作品地址")
    @TableField("photo_zpUrl")
    private String photoZpurl;

    @ApiModelProperty(value = "获奖时间")
    @TableField("photo_hjDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date photoHjdate;

    @ApiModelProperty(value = "奖项id")
    @TableField("photo_jxId")
    @JsonIgnore
    private Integer photoJxid;

    @ApiModelProperty(value = "微信号")
    @TableField("photo_wxId")
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

    @ApiModelProperty(value = "备用字段1")
    @TableField("remark_1")
    @JsonIgnore
    private String remark1;

    @ApiModelProperty(value = "备用字段2")
    @TableField("remark_2")
    @JsonIgnore
    private String remark2;

    @ApiModelProperty(value = "备用字段3")
    @TableField("remark_3")
    @JsonIgnore
    private String remark3;

    @ApiModelProperty(value = "指导老师")
    @JsonIgnore
    private String photoGt;

    @ApiModelProperty(value = "指导老师单位")
    @JsonIgnore
    private String photoGtBelong;

    @ApiModelProperty(value = "指导老师手机号")
    @JsonIgnore
    private String photoGtPhone;

    @ApiModelProperty(value = "参赛状态详情")
    private Integer photoStatusDetail;
}
