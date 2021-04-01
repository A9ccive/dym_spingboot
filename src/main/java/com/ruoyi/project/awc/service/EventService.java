package com.ruoyi.project.awc.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.project.awc.bo.event.EventHisParam;
import com.ruoyi.project.awc.bo.event.EventSyParam;
import com.ruoyi.project.awc.dto.event.PhotoInfoDto;
import com.ruoyi.project.awc.entity.ContestBaseInfo;
import com.ruoyi.project.awc.entity.PhotoInfo;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author
 * @since 2021-03-25
 */
public interface EventService {

    /**
     * 赛事首页
     * @param
     * @return
     */
    IPage<PhotoInfo> eventHomePage(Page<PhotoInfo> page, EventSyParam eventSyParam);

    /**
     * 历史赛事
     * @param
     * @return
     */
    IPage<ContestBaseInfo> eventHisPage(Page<ContestBaseInfo> page, EventHisParam eventHisParam);

    /**
     * 参赛作品or优秀作品
     * @param
     * @return
     */
    IPage<PhotoInfo> photoInfoOrGoodPage(Page<PhotoInfo> page, EventSyParam eventSyParam);

    PhotoInfoDto photoZpDetail(Object id);

}
