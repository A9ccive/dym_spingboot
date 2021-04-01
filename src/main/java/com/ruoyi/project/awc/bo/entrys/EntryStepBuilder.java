package com.ruoyi.project.awc.bo.entrys;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.project.awc.bo.entrys.entity.EntryState;
import com.ruoyi.project.awc.bo.entrys.entity.EntryStep;
import com.ruoyi.project.awc.bo.entrys.entity.StepDetail;
import com.ruoyi.project.awc.bo.entrys.entity.StepInfo;
import com.ruoyi.project.awc.entity.ContestTask;
import com.ruoyi.project.system.domain.SysDictData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *     参赛步骤信息构建类
 * </p>
 * @author sunhongwei
 * @since 2021-03-31
 */

@Data
@AllArgsConstructor
@Slf4j
class EntryStepBuilder {

    /**
     * 参赛步骤信息
     */
    private EntryStep entryStep;

    /**
     * 参赛状态详情
     */
    private int statusDetail;

    /**
     * 获取初始化构建类
     * @param entryStep 初始步骤信息
     * @return 步骤构建类
     */
    static EntryStepBuilder getInitInstance(EntryStep entryStep, int currentStatusDetail) {
        return new EntryStepBuilder(entryStep, currentStatusDetail);
    }
    /**
     * 获取初始化构建类
     * @return 步骤构建类
     */

    static EntryStepBuilder getInitInstance(int currentStatusDetail) {
        return new EntryStepBuilder(new EntryStep(), currentStatusDetail);
    }

    /**
     * 构建事件信息，和下个事件
     * @return 步骤构建类
     */
    EntryStepBuilder buildStepEvent() {
        EntryState currentState = EntryStautsRule.getEntrystateByStateCode(statusDetail);
        this.entryStep.setCurrentStepEvent(currentState.getStateEvent());
        this.entryStep.setCanEntrys(currentState.isEnd());
        if (currentState.isEnd()) {
            return this;
        }
        this.entryStep.setNextStepEvent(currentState.getNextState().getStateEvent());
        return this;
    }

    /**
     * 构建参赛id
     * @param entrysId 参赛id
     * @return 步骤构建类
     */
    EntryStepBuilder builderStepEntrysId(Long entrysId) {
        this.entryStep.setEntrysId(entrysId);
        return this;
    }

    /**
     * 构建步骤基本信息
     *
     * @param sysDictDatas 大类任务信息，从字典获取
     * @param contestTasks 小类任务信息，从任务表获取
     * @return 步骤信息构建类
     */
    EntryStepBuilder buildBaseStepInfo(List<SysDictData> sysDictDatas, List<ContestTask> contestTasks) {
        if (sysDictDatas == null || sysDictDatas.isEmpty()){
            return this;
        }
        List<StepInfo> stepInfos = sysDictDatas.stream()
                .map(sysDictData ->
                    StepInfo.builder()
                            .stepName(sysDictData.getDictLabel())
                            .stepEvent(sysDictData.getDictValue())
                            .sort(sysDictData.getDictSort())
                            .stepList(generateStepDetais(sysDictData, contestTasks))
                            .isFinished(
                                    EntryStautsRule
                                            .getEntryStateByStateEvent(sysDictData.getDictValue())
                                            .getStateCode() < statusDetail)
                            .build()
                ).collect(Collectors.toList());
        this.entryStep.setStepInfos(stepInfos);
        if (log.isDebugEnabled()){
            log.debug("buildBaseStep, entrystep: ", JSON.toJSONString(this.entryStep));
        }
        return this;
    }

    /**
     * 1。当字典类型为finishtask时，根据contesttask获取相应的步骤描述、标题、按钮信息（contestTask的taskCatalog对应字典ListClass）
     * 2.当字典类型为其他时，根据字典点的cssClass设置相应的描述、标题、按钮信息
     * @param sysDictData 大类任务
     * @param contestTasks 小类任务
     * @return 步骤描述信息
     */
    private List<StepDetail> generateStepDetais(SysDictData sysDictData, List<ContestTask> contestTasks) {
        if (EntryStautsRule.EVENT_CODE_FINISHTASK.equals(sysDictData.getDictValue())) {
            final JSONObject cxtJson = JSON.parseObject(sysDictData.getListClass());
            return contestTasks.stream()
                    .map(contestTask ->
                            StepDetail.builder()
                                    .stepTitle(contestTask.getTaskTitle())
                                    .stepDesc(contestTask.getTaskDesc())
                                    .stepBtn(new HashMap<String, String>(){{
                                        put("ett",cxtJson.getJSONObject(contestTask.getTaskCatalog()).getString("ett"));
                                        put("etf",cxtJson.getJSONObject(contestTask.getTaskCatalog()).getString("etf"));
                                    }})
                                    .extUrl(contestTask.getTaskResourceLink())
                                    .build())
                    .collect(Collectors.toList());
        }
        final JSONObject cxtJson = JSON.parseObject(sysDictData.getCssClass());
        return Collections.singletonList(StepDetail.builder()
                .stepTitle(cxtJson.getString("ettitle"))
                .stepDesc(cxtJson.getString("etdesc"))
                .stepBtn(new HashMap<String, String>() {{
                    put("ett", cxtJson.getJSONObject("etbtn").getString("ett"));
                    put("etf", cxtJson.getJSONObject("etbtn").getString("etf"));
                }})
                .build());
    }
}
