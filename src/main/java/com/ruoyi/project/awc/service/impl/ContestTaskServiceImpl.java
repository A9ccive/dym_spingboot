package com.ruoyi.project.awc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.project.awc.entity.ContestTask;
import com.ruoyi.project.awc.entity.QuestionnaireInfo;
import com.ruoyi.project.awc.mapper.ContestTaskMapper;
import com.ruoyi.project.awc.service.ContestTaskService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * 赛事任务 服务实现类
 * </p>
 *
 * @author sunhongwei
 * @since 2021-03-30
 */
@Service
public class ContestTaskServiceImpl extends ServiceImpl<ContestTaskMapper, ContestTask> implements
    ContestTaskService {


    @Override
    public List<ContestTask> queryContestTaskByContestId(Integer contestId) {
        LambdaQueryWrapper<ContestTask> queryWrapper = new LambdaQueryWrapper<>();
        return list();
    }
}
