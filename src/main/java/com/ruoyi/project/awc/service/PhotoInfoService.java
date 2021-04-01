package com.ruoyi.project.awc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.awc.entity.PhotoInfo;

/**
 * <p>
 *  参赛作品服务类
 * </p>
 *
 * @since 2021-03-25
 */
public interface PhotoInfoService extends IService<PhotoInfo> {

    /**
     * 查询参赛信息
     * @param photoUserid 参赛用户id
     * @param photoMatchid 赛事id
     * @return 参赛新信息(赛事id,状态)
     */
    PhotoInfo getStateByContestIdAndUserId(Integer photoUserid, Integer photoMatchid);

    /**
     * 获取参赛状态详情
     * @param id 参赛id
     * @return 参赛状态详情
     */
    PhotoInfo getStateDetailById(Long id);

}
