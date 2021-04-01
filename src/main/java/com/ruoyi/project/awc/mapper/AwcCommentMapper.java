package com.ruoyi.project.awc.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.ruoyi.project.awc.entity.AwcComment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 商品评论 Mapper 接口
 * </p>
 *
 * @author
 * @since 2021-03-31
 */
public interface AwcCommentMapper extends BaseMapper<AwcComment> {
    @Select("select ac.id,ac.content,ac.comment_url,ac.comment_time,ac.favorable_comment_count,ac.bad_comment_count,au.id as userId,au.user_name FROM awc_comment ac,awc_user au,awc_goods ag WHERE ac.user_id = au.id and ag.comment_id = ac.id and ag.comment_id = #{id}")
    List<AwcComment> getComment(Integer id);
}
