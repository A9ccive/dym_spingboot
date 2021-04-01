package com.ruoyi.project.awc.controller.wx.entrys;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.bo.entrys.EntryStautsRule;
import com.ruoyi.project.awc.bo.entrys.EntrysBO;
import com.ruoyi.project.awc.bo.entrys.entity.EntryStep;
import com.ruoyi.project.awc.bo.questionaire.QuestionItem;
import com.ruoyi.project.awc.bo.questionaire.Quetsionaire;
import com.ruoyi.project.awc.dto.entrys.req.EntrysPerformInfoReqDTO;
import com.ruoyi.project.awc.entity.PhotoInfo;
import com.ruoyi.project.awc.service.PhotoInfoService;
import com.ruoyi.project.awc.service.QuestionnaireInfoService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *     参赛报名controller
 * </p>
 *
 * @author  sunhongwei
 * @since 2021-03-31
 */
@RestController
@RequestMapping("app/entry")
@Api(tags="{awcAPP}{参赛报名模块}")
@Slf4j
public class EntryController {
    @Autowired
    private EntrysBO entrysBo;

    @Autowired
    private PhotoInfoService photoInfoService;

    @Autowired
    private QuestionnaireInfoService questionnaireInfoService;

    /**
     * 获取参赛状态
     * @param contestId 赛事id
     * @param userId 用户id
     * @return 参赛状态：isEndEntrys-true可参赛
     */
    @GetMapping("/getEntrysStatus")
    @ApiOperation(value = "1.参赛报名-获取参赛状态", notes = "entrysId参赛id，isEndEntrys-true可参赛")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "contestId",defaultValue = "1",value = "赛事id", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "userId",defaultValue = "3", value = "用户id", dataType = "String")
    })
    public AjaxResult getEntrysStatus(Integer contestId, Integer userId) {
        if (userId == null){
            log.debug("getEntrysStatus userId is null");
            return generateUnEntrysRsp();
        }
        PhotoInfo photoInfo = photoInfoService.getStateByContestIdAndUserId(userId, contestId);
        if (photoInfo == null){
            log.debug("getEntrysStatus no entrys");
            return generateUnEntrysRsp();
        }
        log.debug("getEntrysStatus state:", photoInfo.getPhotoStatus());
        return  AjaxResult.success(new HashMap<String, Object>(){{
            put("entrysId", photoInfo.getId());
            put("isEndEntrys", photoInfo.getPhotoStatus() == EntryStautsRule.STATUS_PART_ENTRYS);
        }});
    }

    /**
     * 获取未参赛响应
     *
     * @return
     */
    private AjaxResult generateUnEntrysRsp() {
        return AjaxResult.success(new HashMap<String, Object>(){{
            put("entrysId", null);
            put("isEndEntrys", false);
        }});
    }

    /**
     * 报名参赛-步骤展示
     * @param step 步骤信息
     * @return 步骤信息
     */
    @GetMapping("/showStep")
    @ApiOperation(value = "2.参赛报名-步骤展示")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "entrysId", value = "参赛id", dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "contestId", defaultValue = "", value = "赛事id", dataType = "String", required = true)
    })
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功", response = EntryStep.class)
    })
    public AjaxResult showEntryStep(@ApiIgnore EntryStep step) {
        step = entrysBo.showEntryStep(step);
        return  AjaxResult.success(step);
    }

    /**
     * 完善个人信息-调查问卷信息
     * @return
     */
    @GetMapping("/getEntryPerQuestion")
    @ApiOperation(value = "3. 参赛报名-完善个人信息-展示调查问卷")
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功", response = Quetsionaire.class)
    })
    public AjaxResult getEntryPerQuestion() {
        return AjaxResult.success(Quetsionaire.Build(questionnaireInfoService.getQtnByType("entrys_per")));
    }

    @PostMapping("perform")
    @ApiOperation(value = "3.1报名-完善个人信息")
    @ApiResponses({
            @ApiResponse(code = 200, message = "请求成功参赛", response = EntryStep.class)
    })
    public AjaxResult perform(EntrysPerformInfoReqDTO entrysPerformInfoReqDTO) {
        return AjaxResult.success(entrysBo.perform(entrysPerformInfoReqDTO));
    }

    public AjaxResult finishtask(){
        return AjaxResult.success();
    }

    public AjaxResult questionnaire(){
        return AjaxResult.success();
    }

    public AjaxResult upload(){
        return AjaxResult.success();
    }

}
