package com.ruoyi.project.awc.dto.entrys.req;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruoyi.project.awc.bo.entrys.EntryStautsRule;
import com.ruoyi.project.awc.entity.PhotoInfo;
import com.ruoyi.project.awc.entity.QuestionnaireInfo;
import com.ruoyi.project.awc.entity.QuestionnaireLog;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 *     完善个人信息请求
 * </p>
 * @author sunhongwei
 * @since 2021-04-01
 */

@Data
@ApiModel(description="报名完善个人信息")
public class EntrysPerformInfoReqDTO {
    @ApiModelProperty(value = "指导老师", example = "张三")
    @JsonIgnore
    private String photoGt;

    @ApiModelProperty(value = "指导老师单位", example = "张三家")
    @JsonIgnore
    private String photoGtBelong;

    @ApiModelProperty(value = "指导老师手机号", example = "15666666666")
    @JsonIgnore
    private String photoGtPhone;

    @ApiModelProperty(value = "微信号", example = "zhangsan")
    @TableField("photo_wxId")
    @JsonIgnore
    private String photoWxid;

    @ApiModelProperty(value = "手机号", example = "15666666666")
    @JsonIgnore
    private Long photoPhone;

    @ApiModelProperty(value = "性别（男，女）", example = "男")
    @JsonIgnore
    private String photoSex;

    @ApiModelProperty(value = "身份证号",example = "15666666666")
    @TableField("photo_idCard")
    @JsonIgnore
    private String photoIdcard;

    @ApiModelProperty(value = "用户id",example = "1024")
    @TableField("photo_userId")
    private Integer photoUserid;

    @ApiModelProperty(value = "赛事id",example = "1024")
    @TableField("photo_matchId")
    private Integer photoMatchid;

    @ApiModelProperty(value = "作者姓名", example = "张三")
    @TableField("photo_zzName")
    private String photoZzname;

    @ApiModelProperty(value = "问卷id", example = "1024")
    private Long qtnId;

    @ApiModelProperty(value = "所在省市", example = "山东")
    private String photoPos;

    @ApiModelProperty(value = "问卷答案",example = "[{title:\"吃了吗\",option:[\"A.吃了\",\"B.没吃\"],store:1,anwser:\"A\"},{title:\"吃饱了吗\",option:[\"A.饱了\",\"B.不饱\",\"C.其他\"],store:2,anwser:\"A\"}]" )
    private String qtnAwnsers;

    /**
     * 根据请求生成新参赛信息
     * @return 参赛信息
     */
    public PhotoInfo generateNewPhotoInfo() {
        return PhotoInfo.builder().photoGt(photoGt).photoGtBelong(photoGtBelong)
                .photoGtPhone(getPhotoGtPhone()).photoWxid(photoWxid).photoPhone(photoPhone)
                .photoSex(photoSex).photoIdcard(photoIdcard).photoUserid(photoUserid).photoMatchid(photoMatchid)
                .photoZzname(photoZzname).photoPos(photoPos).photoStatus(EntryStautsRule.STATUS_PART_ENTRYS).build();
    }

    /**
     * 根据请求生成调查记录信息
     * @param questionnaireInfo 调查问卷
     * @param entrysId 参赛id
     * @return 调查记录
     */
    public QuestionnaireLog generateQuestionnarireLog(QuestionnaireInfo questionnaireInfo, Long entrysId) {
        return QuestionnaireLog.builder().contestId(photoMatchid).userId(photoUserid)
                .qtnId(questionnaireInfo.getQtnId()).qtnLogName(questionnaireInfo.getQtnName()).qtnLogType(questionnaireInfo.getQtnType())
                .qtnLogVersion(questionnaireInfo.getQtnVersion()).qtnLogAwnsers(qtnAwnsers).entrysId(entrysId).build();
    }
}
