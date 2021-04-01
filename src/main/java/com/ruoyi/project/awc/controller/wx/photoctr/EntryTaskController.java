package com.ruoyi.project.awc.controller.wx.photoctr;

import com.alibaba.fastjson.JSON;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.service.ContestTaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *   参赛报名任务controller
 * </p>
 * @since 2021-03-30
 * @author sunhongwei
 */
@RestController
@RequestMapping("/app/entryTask")
@Api("赛事任务")
public class EntryTaskController extends BaseController {

  @Autowired
  private ContestTaskService contestTaskService;

  @GetMapping("/getEntryTask/{contestId}/{photoId}")
  @ApiOperation(value = "报名参赛任务")
  @ApiImplicitParams({
      @ApiImplicitParam(paramType = "query", name = "contestId", value = "赛事id", dataType = "String", required = true),
      @ApiImplicitParam(paramType = "query", name = "photoId", value = "参赛id", dataType = "String", required = true)
  })
  public AjaxResult getEntryTask(@PathVariable Integer contestId, @PathVariable Long photoId) {
    logger.debug("getEntryTask. contestId:", contestId, ",photoId:", photoId);
    logger.debug("getEntryTask. entryTasks:", JSON.toJSONString(1));
    return AjaxResult.success();
  }
}
