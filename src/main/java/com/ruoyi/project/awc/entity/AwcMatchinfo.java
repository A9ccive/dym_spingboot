package com.ruoyi.project.awc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author
 * @since 2021-03-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("awc_matchinfo")
@ApiModel(value="AwcMatchinfo对象", description="")
public class AwcMatchinfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "赛事标题")
    private String matchTitle;

    @ApiModelProperty(value = "海报地址")
    @TableField("match_picUrl")
    private String matchPicurl;

    @ApiModelProperty(value = "创建时间")
    @TableField("match_creatDate")
    private LocalDate matchCreatdate;

    @ApiModelProperty(value = "创建人（用户id）")
    @TableField("match_creatPer")
    private Integer matchCreatper;

    @ApiModelProperty(value = "状态：1未发布，2进行中，3已结束")
    private Integer matchState;

    @ApiModelProperty(value = "开始时间")
    @TableField("match_startDate")
    private LocalDateTime matchStartdate;

    @ApiModelProperty(value = "结束时间")
    @TableField("match_overDate")
    private LocalDateTime matchOverdate;

    @ApiModelProperty(value = "赛事文本")
    private String matchText;

    @ApiModelProperty(value = "修改时间")
    @TableField("match_changeDate")
    private LocalDate matchChangedate;

    @ApiModelProperty(value = "删除")
    private String matchDelete;


}
