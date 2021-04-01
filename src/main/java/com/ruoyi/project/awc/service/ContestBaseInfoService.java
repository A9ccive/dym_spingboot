package com.ruoyi.project.awc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.awc.dto.event.ContestDto;
import com.ruoyi.project.awc.entity.ContestBaseInfo;

/**
 * <p>
 * 赛事基本信息表 服务类
 * </p>
 *
 * @author
 * @since 2021-03-29
 */
public interface ContestBaseInfoService extends IService<ContestBaseInfo> {

    /**
     * 历史赛事-详情
     * @param
     * @return
     */
    ContestDto eventHisDetailById(Object id);

}
