package com.ruoyi.project.awc.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruoyi.project.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 检测类订单检测报告
 * </p>
 *
 * @author 
 * @since 2021-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("awc_check_measure")
@ApiModel(value="AwcCheckMeasure对象", description="检测类订单检测报告")
public class AwcCheckMeasure extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "订单id")
    @JsonIgnore
    private Integer cmOrderId;

    @ApiModelProperty(value = "物流单号")
    @JsonIgnore
    private String cmLogisticsCode;

    @ApiModelProperty(value = "申请检测时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cmSqjcDate;

    @ApiModelProperty(value = "订单状态")
    @JsonIgnore
    private Integer cmOrderState;

    @ApiModelProperty(value = "检测人")
    @JsonIgnore
    private String cmUserName;

    @ApiModelProperty(value = "检测名称")
    private String cmName;

    @ApiModelProperty(value = "上传检测时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cmScjcDate;

    @ApiModelProperty(value = "检测状态")
    private Integer cmState;

    @ApiModelProperty(value = "检测结果时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cmResultDate;

    @ApiModelProperty(value = "检测结果")
    private String cmResultContent;

    @ApiModelProperty(value = "检测上传地址")
    @JsonIgnore
    private String cmUploadAddr;

    @ApiModelProperty(value = "备注")
    @JsonIgnore
    private String remark;

    @ApiModelProperty(value = "用户id")
    @JsonIgnore
    private String userId;

    @ApiModelProperty(value = "备用字段1")
    @JsonIgnore
    private String remark1;

    @ApiModelProperty(value = "备用字段2")
    @JsonIgnore
    private String remark2;

    @ApiModelProperty(value = "备用字段3")
    @JsonIgnore
    private String remark3;

    @TableField(exist = false)
    @ApiModelProperty(value = "确认收货时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date qrshDate;


}
