package com.ruoyi.project.awc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.project.awc.entity.PhotoInfo;
import com.ruoyi.project.awc.entity.QuestionnaireInfo;
import com.ruoyi.project.awc.mapper.QuestionnaireInfoMapper;
import com.ruoyi.project.awc.service.QuestionnaireInfoService;
import org.springframework.stereotype.Service;

import java.util.Comparator;

/**
 * <p>
 * 调查问卷 服务实现类
 * </p>
 *
 * @author sunhongwei
 * @since 2021-04-01
 */
@Service
public class QuestionnaireInfoServiceImpl extends ServiceImpl<QuestionnaireInfoMapper, QuestionnaireInfo> implements QuestionnaireInfoService {

    @Override
    public QuestionnaireInfo getQtnByType(String qtnType) {
        LambdaQueryWrapper<QuestionnaireInfo> queryWrapper = new LambdaQueryWrapper<>();
        return list(queryWrapper.select(QuestionnaireInfo::getQtnName,QuestionnaireInfo::getQtnQuestions,QuestionnaireInfo::getQtnVersion,QuestionnaireInfo::getQtnId)
                .eq(QuestionnaireInfo::getQtnType, qtnType)).stream().max(Comparator.comparingInt(QuestionnaireInfo::getQtnVersion)).get();
    }
}
