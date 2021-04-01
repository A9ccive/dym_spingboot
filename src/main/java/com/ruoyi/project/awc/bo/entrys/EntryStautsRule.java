package com.ruoyi.project.awc.bo.entrys;

import com.ruoyi.project.awc.bo.entrys.entity.EntryState;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *     参赛状态规则
 * </p>
 *
 * @author sunhongwei
 * @since 2021-03-31
 */
public class EntryStautsRule {
    /**
     * 完成部分参赛任务
     */
    public static final int STATUS_PART_ENTRYS = 2;

    /**
     * 完成参赛任务-参赛成功
     */
    public static final int STATUS_ENTRYS = 1;
    /**
     * 完善报名步骤事件
     */
    public static final String EVENT_CODE_PERFORM = "perform";
    /**
     * 完成报名任务步骤事件
     */
    public static final String EVENT_CODE_FINISHTASK = "finishtask";
    /**
     * 完成问卷步骤事件
     */
    public static final String EVENT_CODE_QUESTIONNAIRE = "questionnaire";
    /**
     * 完成上传步骤事件
     */
    public static final String EVENT_CODE_UPLOAD = "upload";

    /**
     * 上传任务
     */
    private final static EntryState uploadState = new EntryState(13,EVENT_CODE_UPLOAD,null, true);

    /**
     * 调研任务
     */
    private final static EntryState questionnarieState = new EntryState(5,EVENT_CODE_QUESTIONNAIRE,uploadState, false);
    /**
     * 完成小类任务
     */
    private final static EntryState finishTaskState = new EntryState(3,EVENT_CODE_FINISHTASK,questionnarieState, false);
    /**
     * 完善信息任务
     */
    private final static EntryState performState = new EntryState(1,EVENT_CODE_PERFORM,finishTaskState, false);

    /**
     * 参赛任务开始
     */
    private final static EntryState startState = new EntryState(0, "start",performState, false);

    /**
     * 规则列表
     */
    private final static List<EntryState> statesRules = Arrays.asList(startState,performState,finishTaskState,questionnarieState,uploadState);

    /**
     * 进行下个状态
     * @param stateEvnet 当前状态
     * @param stateCode 当前状态编码
     * @return 下个状态详情
     */
    public static int toNextState(String stateEvnet, int stateCode) {
        return statesRules.stream().filter(state -> state.getStateCode() == stateCode
                && state.getNextState().getStateEvent().equals(stateEvnet)).collect(Collectors.toList()).get(0).getNextState().getStateCode();
    }

    /**
     * 跟据状态获取状态信息
     * @param stateCode 状态编码
     * @return 状态
     */
    public static EntryState getEntrystateByStateCode(int stateCode) {
        return statesRules.stream().filter(state -> state.getStateCode() == stateCode)
                .collect(Collectors.toList()).get(0);
    }

    /**
     * 根据状态事件获取状态信息
     * @param stateEvent 事件
     * @return 事件信息
     */
    public static EntryState getEntryStateByStateEvent(String stateEvent) {
        return statesRules.stream().filter(state -> state.getStateEvent().equals(stateEvent))
                .collect(Collectors.toList()).get(0);
    }

}
