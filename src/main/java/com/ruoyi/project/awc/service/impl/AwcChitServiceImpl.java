package com.ruoyi.project.awc.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.project.awc.entity.AwcChit;
import com.ruoyi.project.awc.mapper.AwcChitMapper;
import com.ruoyi.project.awc.service.AwcChitService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户电子券金额 服务实现类
 * </p>
 *
 * @author
 * @since 2021-04-01
 */
@Service
public class AwcChitServiceImpl extends ServiceImpl<AwcChitMapper, AwcChit> implements AwcChitService {

    private AwcChitMapper awcChitMapper;

//    @Override
//    public AwcChit findAll(Long awcChit) {
//        return awcChitMapper.selectById(awcChit.getChitUserid());
//    }

    @Override
    public AwcChit findByUserId(Integer id) {
        return awcChitMapper.selectById(id);
    }

    @Override
    public void add(AwcChit awcChit) {
         awcChitMapper.insert(awcChit);
    }

    @Override
    public void update(AwcChit awcChit) {
        awcChitMapper.updateById(awcChit);
    }

    @Override
    public void delete(AwcChit awcChit) {
        awcChitMapper.deleteById(awcChit.getChitUserid());
    }

}
