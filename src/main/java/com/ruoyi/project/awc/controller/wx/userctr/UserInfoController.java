package com.ruoyi.project.awc.controller.wx.userctr;

import com.baomidou.mybatisplus.extension.api.R;
import com.ruoyi.common.utils.check.CheckFiledUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.bo.userbo.UserInfoParam;
import com.ruoyi.project.awc.entity.AwcUser;
import com.ruoyi.project.awc.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import java.util.List;

@RestController
@RequestMapping("/app/userInfo")
@Api(value = "用户信息")
public class UserInfoController extends BaseController {
    @Autowired
    private UserInfoService userInfoService;

    private UserInfoParam userInfoParam;

    /**
     *
     * @return
     */
    @ApiOperation("返回列表")
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public AjaxResult  findAll() {
        try {
            return AjaxResult.success( userInfoService.findAll());
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * @param user
     * @return
     */
    @ApiOperation("增加信息")
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public AjaxResult add(AwcUser user) {
        try {
             userInfoService.add(user);
            return AjaxResult.success();
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * @param user
     * @return
     */
    @ApiOperation("更新信息")
    @RequestMapping(value = "/undate",method = RequestMethod.POST)
    public AjaxResult update(AwcUser user) {

        try {
            userInfoService.update(user);
            return AjaxResult.success();
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * @param ids
     * @return
     */
    @ApiOperation("批量删除")
    @RequestMapping("/delete")
    public AjaxResult delete(Long[] ids) {
        try {
            userInfoService.delete(ids);
            return AjaxResult.success();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     *
     * @return
     */
    @ApiOperation("根据id查询")
    @RequestMapping(value = "/findUserByID",method = RequestMethod.GET)
    public AjaxResult findUserByID(String id) {
        id=userInfoParam.getUserOpenid();
        try {

            userInfoService.findUserByID(id);
            return AjaxResult.success() ;
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }


}
