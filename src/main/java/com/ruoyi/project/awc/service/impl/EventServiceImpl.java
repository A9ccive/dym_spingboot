package com.ruoyi.project.awc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.project.awc.bo.event.EventHisParam;
import com.ruoyi.project.awc.bo.event.EventSyParam;
import com.ruoyi.project.awc.dto.event.PhotoInfoDto;
import com.ruoyi.project.awc.entity.ContestBaseInfo;
import com.ruoyi.project.awc.entity.PhotoInfo;
import com.ruoyi.project.awc.mapper.ContestBaseInfoMapper;
import com.ruoyi.project.awc.mapper.PhotoInfoMapper;
import com.ruoyi.project.awc.service.EventService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

import static com.ruoyi.common.constant.Constants.CONTEST_STATE_END;

/**
 * <p>
 * 赛事管理 服务实现类
 * </p>
 *
 * @author
 * @since 2021-03-25
 */
@Service
public class EventServiceImpl implements EventService {


    @Autowired
    private PhotoInfoMapper photoInfoMapper;

    @Autowired
    private ContestBaseInfoMapper contestBaseInfoMapper;


    /**
     * 赛事首页
     *
     * @param
     * @return
     */
    @Override
    public IPage<PhotoInfo> eventHomePage(Page<PhotoInfo> page, EventSyParam eventSyParam) {

        QueryWrapper<PhotoInfo> queryWrapper = new QueryWrapper<PhotoInfo>()
//                .like(StringUtils.isNotBlank(eventSyParam.getTitle()), "photo_zpName", eventSyParam.getTitle())
//                .eq(eventSyParam.getEType() != null, "photo_type", eventSyParam.getEType())
                ;
        IPage<PhotoInfo> photoInfoIPage = photoInfoMapper.selectPage(page, queryWrapper);
        photoInfoIPage.getRecords().stream().forEach(
                photoInfo -> {
                    //点赞数量查询
                    //..

                }
        );

        return photoInfoIPage;
    }


    /**
     * 历史赛事
     *
     * @param
     * @return
     */
    @Override
    public IPage<ContestBaseInfo> eventHisPage(Page<ContestBaseInfo> page, EventHisParam eventHisParam) {
        QueryWrapper<ContestBaseInfo> queryWrapper = new QueryWrapper<ContestBaseInfo>()
                .like(StringUtils.isNotBlank(eventHisParam.getTitle()), "contest_name", eventHisParam.getTitle())
                .eq("contest_state",CONTEST_STATE_END);
        IPage<ContestBaseInfo> contestBaseInfoIPage = contestBaseInfoMapper.selectPage(page, queryWrapper);
        contestBaseInfoIPage.getRecords().forEach(
                contestBaseInfo -> {
                    //其他属性
                }
        );
        return contestBaseInfoIPage;
    }


    /**
     * 参赛作品or优秀作品
     *
     * @param
     * @return
     */
    @Override
    public IPage<PhotoInfo> photoInfoOrGoodPage(Page<PhotoInfo> page, EventSyParam eventSyParam) {

        //作品(页面选择)：1.优秀作品页面 2.参赛作品页面
        Integer pType = eventSyParam.getPType();
        Integer isGood = pType == 1 ? 1 : null;

        //作品类型
        Integer photoType = eventSyParam.getPhotoType();

        QueryWrapper<PhotoInfo> queryWrapper = new QueryWrapper<PhotoInfo>()
                .like(StringUtils.isNotBlank(eventSyParam.getPhotoZpName()), "photo_zpName", eventSyParam.getPhotoZpName())
                .like(StringUtils.isNotBlank(eventSyParam.getPhotoZzName()), "photo_zzName", eventSyParam.getPhotoZzName())
                .eq("photo_type", photoType)
                .eq(isGood != null, "photo_better", isGood);
        IPage<PhotoInfo> photoInfoIPage = photoInfoMapper.selectPage(page, queryWrapper);
        photoInfoIPage.getRecords().stream().forEach(
                photoInfo -> {
                    //其他数据查询
                    //..

                }
        );

        return photoInfoIPage;
    }


    @Override
    public PhotoInfoDto photoZpDetail(Object id) {
        PhotoInfo photoInfo = photoInfoMapper.selectById((Serializable) id);
        Assert.notNull(photoInfo,"当前作品不存在，请联系管理员！");

        //详情
        PhotoInfoDto photoInfoDto =new PhotoInfoDto();
        BeanUtils.copy(photoInfo,photoInfoDto);

        return photoInfoDto;
    }
}
