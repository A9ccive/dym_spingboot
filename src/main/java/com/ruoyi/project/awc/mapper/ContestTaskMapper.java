package com.ruoyi.project.awc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.project.awc.entity.ContestTask;
import java.util.List;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 赛事任务 Mapper 接口
 * </p>
 *
 * @author sunhongwei
 * @since 2021-03-30
 */
public interface ContestTaskMapper extends BaseMapper<ContestTask> {

  @Select("select ")
  List<ContestTask> getEntryTaskFinishedDetail(Long contestId, long photoId);
}
