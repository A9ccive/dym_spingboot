package com.ruoyi.project.awc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品评论表
 * </p>
 *
 * @author
 * @since 2021-03-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("awc_comment")
@ApiModel(value="AwcComment对象", description="商品评论表")
public class AwcComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "评论主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "评论图片地址")
    private String commentUrl;

    @ApiModelProperty(value = "评论时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentTime;

    @ApiModelProperty(value = "好评个数")
    @TableField("favorable_comment_count")
    private Integer favorableCommentCount;

    @ApiModelProperty(value = "差评个数")
    @TableField("bad_comment_count")
    private Integer badCommentCount;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "评论作者")
    @TableField(exist = false)
    private String userName;

    @ApiModelProperty(value = "创建时间")
    private Date awcCreate;

    @ApiModelProperty(value = "修改时间")
    private Date awcModified;

    @ApiModelProperty(value = "0未删除，1删除")
    private Integer awcDelete;

    @ApiModelProperty(value = "备用1")
    private String remark1;

    @ApiModelProperty(value = "备用2")
    private String remark2;

    @ApiModelProperty(value = "备用3")
    private String remark3;
}