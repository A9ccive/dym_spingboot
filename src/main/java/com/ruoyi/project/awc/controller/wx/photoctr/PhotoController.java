package com.ruoyi.project.awc.controller.wx.photoctr;

import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.entity.PhotoInfo;
import com.ruoyi.project.awc.service.PhotoInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <p>
 *   参赛作品controller
 * </p>
 */
@RestController("/app")
@RequestMapping("/photo")
@Api("参赛作品管理")
public class PhotoController extends BaseController {

  @Autowired
  private PhotoInfoService photoInfoService;

  @PostMapping("perform")
  @ApiOperation(value = "报名-完善个人信息")
  @ApiImplicitParams({
      @ApiImplicitParam(paramType = "query", name = "photoZzname", value = "姓名", dataType = "String", required = true),
      @ApiImplicitParam(paramType = "query", name = "photoWxid", value = "微信号", dataType = "String", required = true),
      @ApiImplicitParam(paramType = "query", name = "photoPhone", value = "手机号", dataType = "String", required = true),
      @ApiImplicitParam(paramType = "query", name = "photoSex", value = "性别", dataType = "String", required = true),
      @ApiImplicitParam(paramType = "query", name = "photoIdcard", value = "身份证号", dataType = "String", required = true),
      @ApiImplicitParam(paramType = "query", name = "photoPos", value = "所在省市", dataType = "String", required = true),
      @ApiImplicitParam(paramType = "query", name = "photoGt", value = "指导老师", dataType = "String", required = true),
      @ApiImplicitParam(paramType = "query", name = "photoGtPhone", value = "指导老师单位", dataType = "String", required = true),
      @ApiImplicitParam(paramType = "query", name = "photoUserid", value = "用户id", dataType = "String", required = true),
      @ApiImplicitParam(paramType = "query", name = "photoMatchid", value = "参赛id", dataType = "String", required = true)
  })
  public AjaxResult perform(@ApiIgnore PhotoInfo photoInfo) {
    photoInfoService.save(photoInfo);
    return success(photoInfo.getId().toString());
  }
}
