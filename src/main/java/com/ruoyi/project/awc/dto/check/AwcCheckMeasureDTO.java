package com.ruoyi.project.awc.dto.check;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 检测类订单检测报告详情
 * </p>
 *
 * @author 
 * @since 2021-03-31
 */
@Data
@ApiModel(value="检测类订单检测报告详情", description="检测类订单检测报告详情")
public class AwcCheckMeasureDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @ApiModelProperty(value = "检测人")
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
    private String cmUploadAddr;

    @ApiModelProperty(value = "备注")
    private String remark;

}
