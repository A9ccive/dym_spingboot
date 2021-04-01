package com.ruoyi.project.awc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.project.awc.entity.AwcComment;
import com.ruoyi.project.awc.mapper.AwcCommentMapper;
import com.ruoyi.project.awc.service.AwcCommentService;
import io.jsonwebtoken.lang.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品评论 服务实现类
 * </p>
 *
 * @author
 * @since 2021-03-31
 */
@Service
public class AwcCommentServiceImpl extends ServiceImpl<AwcCommentMapper, AwcComment> implements AwcCommentService {
    private AwcComment awcComment;
    @Autowired
    private AwcCommentMapper awcCommentMapper;
    @Override
    public List<AwcComment> getComment(Object id) {
        Integer pid = Integer.parseInt(id.toString());
        List<AwcComment> awcComments = awcCommentMapper.getComment(pid);
        Assert.notNull(awcComments,"当前商品评论不存在");
        return awcComments;
    }
}
