package com.ruoyi.project.awc.dto.event;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.project.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 作品详情信息
 * </p>
 *
 * @author zhagnyong
 * @since 2021-03-30
 */
@Data
@ApiModel(value="作品详情", description="作品详情信息")
public class PhotoInfoDto extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    /**
     * 作者
     */
    private String photoZzname;
    /**
     * 作品类型
     */
    private Integer photoType;
    /**
     * 作品名称
     */
    private String photoZpname;
    /**
     * 作品描述
     */
    private String photoDesc;

    private String photoFmurl;
    private String photoBaiduurl;
    /**
     * 点赞数量
     */
    private Integer photoGoodNum;
    /**
     * 是否优秀
     */
    private Integer photoBetter;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date photoHjdate;



}
