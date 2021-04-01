package com.ruoyi.project.awc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.awc.entity.ContestTask;

import java.util.List;

/**
 * <p>
 * 赛事任务 服务类
 * </p>
 *
 * @author sunhongwei
 * @since 2021-03-30
 */
public interface ContestTaskService extends IService<ContestTask> {
    List<ContestTask> queryContestTaskByContestId(Integer contestId);
}
