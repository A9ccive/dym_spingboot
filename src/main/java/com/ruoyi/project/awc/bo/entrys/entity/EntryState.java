package com.ruoyi.project.awc.bo.entrys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 *     参赛状态
 * </p>
 *
 * @author sunhongwei
 * @since 2021-03-31
 */
@Data
@AllArgsConstructor
public class EntryState {
    /**
     * 状态编码 二进制表示
     */
    private int stateCode;
    /**
     * 状态事件
     */
    private String stateEvent;
    /**
     * 下级状态
     */
    private EntryState nextState;

    /**
     * 是否为结束
     */
    private boolean isEnd;
}
