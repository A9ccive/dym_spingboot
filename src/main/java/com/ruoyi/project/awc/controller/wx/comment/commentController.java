package com.ruoyi.project.awc.controller.wx.comment;

import com.ruoyi.common.utils.check.CheckFiledUtils;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.bo.goods.GoodDetailParam;
import com.ruoyi.project.awc.entity.AwcComment;
import com.ruoyi.project.awc.service.impl.AwcCommentServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/comment")
@Api(value = "商品评论")
public class commentController {

    @Autowired
    private AwcCommentServiceImpl awcCommentService;

    private AwcComment awcComment;

    /**
     * 商品评论
     * @param
     * @return
     */
    @ApiOperation("商品评论")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "商品id", dataType = "Integer"),
    })
    @RequestMapping(value = "/getComment", method = RequestMethod.GET)
    public AjaxResult getComment(GoodDetailParam goodDetailParam) {

        try {
            //参数校验
            CheckFiledUtils.isFieldNull(goodDetailParam);
            return AjaxResult.success(awcCommentService.getComment(goodDetailParam.getId()));

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }
}