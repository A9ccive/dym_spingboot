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
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * <p>
 * 答题记录
 * </p>
 *
 * @author
 * @since 2021-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("awc_answer")
@ApiModel(value="AwcAnswer对象", description="答题记录")
public class AwcAnswer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "分数")
    private BigDecimal answerGrade;

    @ApiModelProperty(value = "答题时间")
    private LocalDateTime answerTime;

    @ApiModelProperty(value = "答题用时")
    @TableField("answer_userTime")
    private LocalTime answerUsertime;

    @ApiModelProperty(value = "答题次数")
    private Integer answerNum;

    @ApiModelProperty(value = "答题总分数")
    @TableField("answer_gradeTotal")
    private BigDecimal answerGradetotal;

    @ApiModelProperty(value = "答题文本")
    private String answerText;

    @ApiModelProperty(value = "答题正确率")
    private BigDecimal answerTrue;

    @ApiModelProperty(value = "用户id")
    @TableField("answer_userId")
    private Integer answerUserid;

    @ApiModelProperty(value = "备用1")
    private String remark1;

    @ApiModelProperty(value = "备用2")
    private String remark2;

    @ApiModelProperty(value = "备用2")
    private String remark3;

    @ApiModelProperty(value = "创建时间")
    private LocalDate answerCreate;

    @ApiModelProperty(value = "修改时间")
    private LocalDateTime answerModified;

    @ApiModelProperty(value = "是否删除（0未删除，1删除）")
    private Integer answerDelete;


}
