package com.ruoyi.project.awc.controller.wx.event;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.utils.check.CheckFiledUtils;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.bo.event.ByIdParam;
import com.ruoyi.project.awc.bo.event.EventHisParam;
import com.ruoyi.project.awc.bo.event.EventSyParam;
import com.ruoyi.project.awc.dto.event.ContestDto;
import com.ruoyi.project.awc.entity.ContestBaseInfo;
import com.ruoyi.project.awc.entity.PhotoInfo;
import com.ruoyi.project.awc.service.ContestBaseInfoService;
import com.ruoyi.project.awc.service.EventService;
import io.github.yedaxia.apidocs.ApiDoc;
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
 * 赛事管理模块
 */
@RestController
@RequestMapping("/app/event")
@Api(value = "赛事管理模块")
public class EventController {


    protected static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    private EventService eventService;

    @Autowired
    private ContestBaseInfoService contestBaseInfoService;


    /**
     * TODO 赛事首页(ue有变更)
     * @param page
     * @param eventSyParam
     * @return
     */
    @ApiOperation("赛事首页")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "title", value = "赛事标题", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "eType", value = "赛事类型选择", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "current", value = "当前页", dataType = "long"),
            @ApiImplicitParam(paramType = "query", name = "size", value = "每页显示条数,默认 10", dataType = "long"),
    })
    @RequestMapping(value = "/eventHomePage", method = RequestMethod.GET)
    public AjaxResult eventHomePage(@ApiIgnore Page<PhotoInfo> page, EventSyParam eventSyParam) {
        try {
            //参数校验
            CheckFiledUtils.isFieldNull(eventSyParam);
            return AjaxResult.success(eventService.eventHomePage(page,eventSyParam));
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 历史赛事
     * @param page
     * @param eventHisParam
     * @return
     */
//    @ApiDoc(result = ContestBaseInfo.class, url = "/app/event/eventHisPage", method = "GET")
    @ApiOperation("历史赛事")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "title", value = "赛事标题", dataType = "String"),
    })
    @RequestMapping(value = "/eventHisPage", method = RequestMethod.GET)
    public AjaxResult eventHisPage(@ApiIgnore Page<ContestBaseInfo> page, EventHisParam eventHisParam) {
        try {
            //参数校验
            CheckFiledUtils.isFieldNull(eventHisParam);
            return AjaxResult.success(eventService.eventHisPage(page,eventHisParam));
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 历史赛事-详情
     * @param byIdParam
     * @return
     */
    @ApiDoc(result = ContestDto.class, url = "/app/event/eventHisDetail", method = "GET")
    @ApiOperation("历史赛事详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "赛事id", dataType = "Integer"),
    })
    @RequestMapping(value = "/eventHisDetail", method = RequestMethod.GET)
    public AjaxResult eventHisDetail(ByIdParam byIdParam) {
        try {
            //参数校验
            CheckFiledUtils.isFieldNull(byIdParam);
            return AjaxResult.success(contestBaseInfoService.eventHisDetailById(byIdParam.getId()));

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }


    /**
     * 参赛作品or优秀作品
     * @param page
     * @param eventSyParam
     * @return
     */
//    @ApiDoc(result = PhotoInfo.class, url = "/app/event/photoInfoOrGoodPage", method = "GET")
    @ApiOperation("参赛作品or优秀作品")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "photoZpName", value = "作品名称", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "photoZzName", value = "作者", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "pType", value = "作品(页面选择)：1.优秀作品页面 2.参赛作品页面", dataType = "Integer",required = true),
            @ApiImplicitParam(paramType = "query", name = "photoType", value = "作品类型(对应字典表)：视频作品/平面作品/实物设计/区域作品/在线课程/有奖问答", dataType = "Integer",required = true),
    })
    @RequestMapping(value = "/photoInfoOrGoodPage", method = RequestMethod.GET)
    public AjaxResult photoInfoOrGoodPage(@ApiIgnore Page<PhotoInfo> page, EventSyParam eventSyParam) {
        try {
            //参数校验
            CheckFiledUtils.isFieldNull(eventSyParam);
            return AjaxResult.success(eventService.photoInfoOrGoodPage(page,eventSyParam));
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 作品详情
     * @param byIdParam
     * @return
     */
//    @ApiDoc(result = PhotoInfoDto.class, url = "/app/event/photoZpDetail", method = "GET")
    @ApiOperation("作品详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "作品id", dataType = "Integer"),
    })
    @RequestMapping(value = "/photoZpDetail", method = RequestMethod.GET)
    public AjaxResult photoZpDetail(ByIdParam byIdParam) {
        try {
            //参数校验
            CheckFiledUtils.isFieldNull(byIdParam);
            return AjaxResult.success(eventService.photoZpDetail(byIdParam.getId()));

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

}
