package com.ruoyi.project.awc.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.bean.BeanUtils;
import com.ruoyi.project.awc.dto.check.AwcCheckMeasureDTO;
import com.ruoyi.project.awc.entity.AwcCheckMeasure;
import com.ruoyi.project.awc.mapper.AwcCheckMeasureMapper;
import com.ruoyi.project.awc.service.AwcCheckMeasureService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 检测类订单检测报告 服务实现类
 * </p>
 *
 * @author
 * @since 2021-03-31
 */
@Service
public class AwcCheckMeasureServiceImpl extends ServiceImpl<AwcCheckMeasureMapper, AwcCheckMeasure> implements AwcCheckMeasureService {

    @Autowired
    private AwcCheckMeasureMapper awcCheckMeasureMapper;


    /**
     * 历史检测
     *
     * @param
     * @param page
     * @return
     */
    @Override
    public IPage<AwcCheckMeasure> checkHisPage(Page<AwcCheckMeasure> page) {
        //获取当前登录用户id
        String userId = null;
        QueryWrapper<AwcCheckMeasure> awcQw = new QueryWrapper<AwcCheckMeasure>()
                .eq(userId != null, "user_id", "");
        IPage<AwcCheckMeasure> resPage = awcCheckMeasureMapper.selectPage(page, awcQw);
        resPage.getRecords().stream().forEach(
                awcCheckMeasure -> {
                    //订单号
                    Integer cmOrderId = awcCheckMeasure.getCmOrderId();
                    //订单状态
                    Integer cmOrderState = awcCheckMeasure.getCmOrderState();
                    //...确认收货时间
                    //if (cmOrderId.equals(Contant.QRSH_STATE)){awcCheckMeasure.setQrshDate();}

                }
        );
        return resPage;

    }


    /**
     * 查看检测结果
     *
     * @param
     * @return
     */
    @Override
    public AwcCheckMeasureDTO checkResultDetail(Object id) {
        AwcCheckMeasure awcCheckMeasure = awcCheckMeasureMapper.selectById((Serializable) id);
        Assert.notNull(awcCheckMeasure, "当前检测结果不存在，请联系管理员！");

        AwcCheckMeasureDTO awcCheckMeasureDTO = new AwcCheckMeasureDTO();
        BeanUtils.copy(awcCheckMeasure, awcCheckMeasureDTO);
        return awcCheckMeasureDTO;
    }
}
