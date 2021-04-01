package com.ruoyi.project.awc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.awc.entity.QuestionnaireInfo;

/**
 * <p>
 * 调查问卷 服务类
 * </p>
 *
 * @author sunhongwei
 * @since 2021-04-01
 */
public interface QuestionnaireInfoService extends IService<QuestionnaireInfo> {

    /**
     * 根据类型查询
     * @param qtnType
     * @return
     */
    QuestionnaireInfo getQtnByType(String qtnType);

}
