package com.ruoyi.project.awc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * 赛事基本信息表
 * </p>
 *
 * @author
 * @since 2021-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("contest_base_info")
@ApiModel(value="ContestBaseInfo对象", description="赛事基本信息表")
public class ContestBaseInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "赛事名称")
    private String contestName;

    @ApiModelProperty(value = "赛事海报")
    private String contestPoster;

    @ApiModelProperty(value = "赛事状态：0 未启动，1进行中，2已结束")
    private Integer contestState;

    @ApiModelProperty(value = "赛事内容")
    private String contestContent;

    @ApiModelProperty(value = "赛事创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date contestCreatetime;

    @ApiModelProperty(value = "赛事创建人")
    private Integer contestCreateoperid;

    @ApiModelProperty(value = "赛事开始时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date contestEfftime;

    @ApiModelProperty(value = "赛事结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date contestExptime;


}
