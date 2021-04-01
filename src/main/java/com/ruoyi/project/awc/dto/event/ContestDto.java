package com.ruoyi.project.awc.dto.event;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * <p>
 * 赛事详情返回
 * </p>
 *
 * @author
 * @since 2021-03-29
 */
@Data
public class ContestDto {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String contestName;
    private String contestPoster;

    @ApiModelProperty(value = "赛事状态：0 未启动，1进行中，2已结束")
    private Integer contestState;

    @ApiModelProperty(value = "赛事内容")
    private String contestContent;

    @ApiModelProperty(value = "赛事创建时间")
    private Date contestCreatetime;

    @ApiModelProperty(value = "赛事创建人")
    private Integer contestCreateoperid;

    @ApiModelProperty(value = "赛事开始时间")
    private Date contestEfftime;

    @ApiModelProperty(value = "赛事结束时间")
    private Date contestExptime;


}
