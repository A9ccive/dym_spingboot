package com.ruoyi.project.awc.controller.wx.userctr;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.entity.AwcMatchinfo;
import com.ruoyi.project.awc.service.impl.applyServiceImpl;
import com.ruoyi.project.awc.entity.PhotoInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/app/apply")
@Api(value = "我的报名")
public class applyController {

    @Autowired
    private applyServiceImpl applyService;

    private PhotoInfo photoInfo;

    private AwcMatchinfo awcMatchinfo;

    /**
     * 赛事标题
     * @return
     */
    @ApiOperation("获取赛事标题")
    @RequestMapping(value = "/showTitle",method = RequestMethod.GET)
    public AjaxResult showTitle() {
        try {
            return AjaxResult.success(applyService.showTital());
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 获取报名信息
     *
     * @return
     */
    @ApiOperation("获取报名信息")
    @RequestMapping(value = "/getMyApplyInfo",method = RequestMethod.GET)
    public AjaxResult getMyApplyInfo() {

        try {

            return AjaxResult.success(applyService.getMyApplyInfo());
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }

    }

    /**
     * 获取作品信息
     *
     * @return
     */
    @ApiOperation("获取作品信息")
    @RequestMapping(value = "/getMyPhotoInfo",method = RequestMethod.GET)
    public AjaxResult getMyPhotoInfo() {
        try {
            return AjaxResult.success(applyService.getMyPhotoInfo());
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 获奖
     * @return
     */
    @ApiOperation("获取获奖信息")
    @RequestMapping(value = "/getPrizeInfo",method = RequestMethod.GET)
    public AjaxResult getPrizeInfo() {

        try {
            return  AjaxResult.success(applyService.getPrizeInfo());
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
            }
    }


}
