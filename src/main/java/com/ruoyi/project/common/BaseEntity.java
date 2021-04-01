package com.ruoyi.project.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity基类
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "awc_create", fill = FieldFill.INSERT)
    @JsonIgnore
    private Date awcCreate;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "awc_modified", fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    private Date awcModified;


    @JsonIgnore
    @TableField("awc_delete")
    @TableLogic
    @ApiModelProperty(value = "0为未删除  1为删除")
    private Integer awcDelete = 0;

}
