package com.ruoyi.project.awc.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.awc.entity.AwcComment;

import java.util.List;

/**
 * <p>
 * 商品评论 服务类
 * </p>
 *
 * @author
 * @since 2021-03-31
 */
public interface AwcCommentService extends IService<AwcComment> {
    /**
     * 获取商品评论
     * @return
     */
    List<AwcComment> getComment(Object id);
        

}
