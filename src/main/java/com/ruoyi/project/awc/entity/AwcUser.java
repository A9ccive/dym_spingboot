package com.ruoyi.project.awc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 个人信息
 * </p>
 *
 * @author
 * @since 2021-03-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_user")
@ApiModel(value="SysUser对象", description="个人信息")

public class AwcUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @ApiModelProperty(value = "姓名")
    private String userName;

    @ApiModelProperty(value = "微信开放id")
    private String userOpenid;

    @ApiModelProperty(value = "微信号")
    private String userWxid;

    @ApiModelProperty(value = "手机号")
    private Long userPhone;

    @ApiModelProperty(value = "性别（1男，2女）")
    private Integer userSex;

    @ApiModelProperty(value = "身份证号")
    private String userIdcard;

    @ApiModelProperty(value = "所在省市")
    private String userLocal;




}
