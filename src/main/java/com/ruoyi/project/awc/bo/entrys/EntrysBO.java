package com.ruoyi.project.awc.bo.entrys;

import com.ruoyi.common.utils.DictUtils;
import com.ruoyi.project.awc.bo.entrys.entity.EntryStep;
import com.ruoyi.project.awc.bo.questionaire.Quetsionaire;
import com.ruoyi.project.awc.dto.entrys.req.EntrysPerformInfoReqDTO;
import com.ruoyi.project.awc.entity.ContestTask;
import com.ruoyi.project.awc.entity.PhotoInfo;
import com.ruoyi.project.awc.entity.QuestionnaireLog;
import com.ruoyi.project.awc.service.ContestTaskService;
import com.ruoyi.project.awc.service.PhotoInfoService;
import com.ruoyi.project.awc.service.QuestionnaireInfoService;
import com.ruoyi.project.awc.service.QuestionnaireLogService;
import com.ruoyi.project.system.domain.SysDictData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EntrysBO {

    @Autowired
    private ContestTaskService contestTaskService;

    @Autowired
    private PhotoInfoService photoInfoService;

    @Autowired
    private QuestionnaireInfoService questionnaireInfoService;

    @Autowired
    private QuestionnaireLogService questionnaireLogService;

    /**
     * 展示报名步骤信息
     * @param step 步骤信息
     * @return 步骤信息
     */
    public EntryStep showEntryStep(EntryStep step) {
        List<SysDictData> sysDictDatas= DictUtils.getDictCache("entry_centos_step");
        List<ContestTask> contestTasks = contestTaskService.queryContestTaskByContestId(step.getContestId());
        return EntryStepBuilder.getInitInstance(step, getStateDetail(step.getEntrysId())).buildStepEvent().buildBaseStepInfo(sysDictDatas, contestTasks).getEntryStep();
    }

    /**
     * 完善个人信息
     * @param entrysPerformInfoReqDTO 个人信息
     * @return 步骤信息
     */
    @Transactional
    public EntryStep perform(EntrysPerformInfoReqDTO entrysPerformInfoReqDTO){
        int detail = EntryStautsRule.toNextState("perform", 0);
        PhotoInfo photoInfo = entrysPerformInfoReqDTO.generateNewPhotoInfo();
        photoInfo.setPhotoStatusDetail(detail);
        photoInfoService.save(photoInfo);
        Long entrysId = photoInfo.getId();
        QuestionnaireLog questionnaireLog = entrysPerformInfoReqDTO.generateQuestionnarireLog(
                questionnaireInfoService.getById(entrysPerformInfoReqDTO.getQtnId()),entrysId);
        questionnaireLogService.save(questionnaireLog);
        return EntryStepBuilder.getInitInstance(detail).buildStepEvent().builderStepEntrysId(entrysId).getEntryStep();
    }

    private int getStateDetail(Long entrysId) {
        if (entrysId != null){
            PhotoInfo photoInfo = photoInfoService.getStateDetailById(entrysId);
            if (photoInfo != null){
                return photoInfo.getPhotoStatusDetail();
            }
        }
        return 0;
    }
}
