package com.ruoyi.project.awc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.awc.dto.check.AwcCheckMeasureDTO;
import com.ruoyi.project.awc.entity.AwcCheckMeasure;

/**
 * <p>
 * 检测类订单检测报告 服务类
 * </p>
 *
 * @author 
 * @since 2021-03-31
 */
public interface AwcCheckMeasureService extends IService<AwcCheckMeasure> {
    /**
     * 历史检测
     * @param
     * @param page
     * @return
     */
    IPage<AwcCheckMeasure> checkHisPage(Page<AwcCheckMeasure> page);

    /**
     * 查看检测结果
     * @param
     * @return
     */
    AwcCheckMeasureDTO checkResultDetail(Object id);

}
