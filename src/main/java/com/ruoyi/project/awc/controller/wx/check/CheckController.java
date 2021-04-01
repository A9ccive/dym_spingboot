package com.ruoyi.project.awc.controller.wx.check;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.utils.check.CheckFiledUtils;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.bo.event.ByIdParam;
import com.ruoyi.project.awc.entity.AwcCheckMeasure;
import com.ruoyi.project.awc.service.AwcCheckMeasureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 检测模块
 */
@RestController
@RequestMapping("/app/check")
@Api(value = "检测模块")
public class CheckController {


    protected static final Logger logger = LoggerFactory.getLogger(CheckController.class);

    @Autowired
    private AwcCheckMeasureService awcCheckMeasureService;


    /**
     * 历史检测
     * @param page
     * @return
     */
//    @ApiDoc(result = AwcCheckMeasure.class, url = "/app/event/eventHomePage", method = "GET")
    @ApiOperation("历史检测")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "商品id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "current", value = "当前页", dataType = "long"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "每页显示条数,默认 10", dataType = "long"),
    })
    @RequestMapping(value = "/checkHisPage", method = RequestMethod.GET)
    public AjaxResult checkHisPage(@ApiIgnore Page<AwcCheckMeasure> page) {
        try {
            IPage<AwcCheckMeasure> resPage = awcCheckMeasureService.checkHisPage(page);
            return AjaxResult.success(resPage);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 查看检测结果
     * @param
     * @return
     */
//    @ApiDoc(result = AwcCheckMeasure.class, url = "/app/check/checkResultDetail", method = "GET")
    @ApiOperation("查看检测结果")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "检测信息id", dataType = "Long"),
    })
    @RequestMapping(value = "/checkResultDetail", method = RequestMethod.GET)
    public AjaxResult checkResultDetail(ByIdParam byIdParam) {
        try {
            //参数校验
            CheckFiledUtils.isFieldNull(byIdParam);
            return AjaxResult.success(awcCheckMeasureService.checkResultDetail(byIdParam.getId()));

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }


}
