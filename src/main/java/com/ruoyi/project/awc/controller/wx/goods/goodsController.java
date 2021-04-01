package com.ruoyi.project.awc.controller.wx.goods;

import com.ruoyi.common.utils.check.CheckFiledUtils;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.bo.goods.GoodDetailParam;
import com.ruoyi.project.awc.entity.AwcGoods;
import com.ruoyi.project.awc.service.impl.AwcGoodsServiceImpl;
import com.ruoyi.project.system.domain.SysDictData;
import com.ruoyi.project.system.service.ISysDictDataService;
import io.jsonwebtoken.lang.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.ruoyi.common.constant.Constants.SYS_SQJC_GOODS;

@RestController
@RequestMapping("/app/goods")
@Api(value = "商品信息")
public class goodsController {

    @Autowired
    private AwcGoodsServiceImpl awcGoodsService;

    @Autowired
    private ISysDictDataService sysDictDataService;

    private AwcGoods awcGoods;



    /**
     * 商品详情
     * @param
     * @return
     */
    @ApiOperation("商品详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "商品id", dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "isCheck", value = "是否申请检测", dataType = "Boolean"),
    })
    @RequestMapping(value = "/goodsDetail", method = RequestMethod.GET)
    public AjaxResult getGoodsInfo(GoodDetailParam goodDetailParam) {
        try {
            //判断是否是申请检测的商品详情
            Boolean isCheck = goodDetailParam.getIsCheck();
            if (isCheck){
                SysDictData sysDictData = sysDictDataService.selectDictDataByDictType(SYS_SQJC_GOODS);
                Assert.notNull(sysDictData,"字典表配置有误,请联系系统管理员！");
                goodDetailParam.setId(sysDictData.getDictValue());
            }
            //参数校验
            CheckFiledUtils.isFieldNull(goodDetailParam);

            return AjaxResult.success(awcGoodsService.getGoodsInfo(goodDetailParam.getId()));

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }
}
