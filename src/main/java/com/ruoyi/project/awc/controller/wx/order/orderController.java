package com.ruoyi.project.awc.controller.wx.order;


import com.ruoyi.common.utils.check.CheckFiledUtils;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.bo.order.ByIdParam;
import com.ruoyi.project.awc.dto.goods.GoodsDto;
import com.ruoyi.project.awc.entity.AwcOrder;
import com.ruoyi.project.awc.service.AwcOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * <p>
 *   参赛作品controller
 * </p>
 */
@RestController
@RequestMapping("app/order")
@Api("订单管理")
public class orderController extends BaseController {

    @Autowired
    private AwcOrderService awcOrderService;

    @PostMapping("buynow")
    @ApiOperation(value = "订单-立即购买")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "goodsName", value = "商品名称", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "goodsPrice", value = "商品单价", dataType = "BigDecimal", required = false),
            @ApiImplicitParam(paramType = "query", name = "goodsBannerUrl", value = "商品banner地址", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "query", name = "buySpecification", value = "规格", dataType = "String", required = false),
            @ApiImplicitParam(paramType = "query", name = "buyCount", value = "数量", dataType = "Integer", required = false)
    })
    public AjaxResult perform(@ApiIgnore AwcOrder awcOrder) {
        awcOrderService.save(awcOrder);
        return success(awcOrder.getId().toString());
    }
    /**
     * 订单详情
     * @param
     * @return
     */
    @ApiOperation("订单详情")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "订单id", dataType = "Integer"),
    })
    @RequestMapping(value = "/orderDetail", method = RequestMethod.GET)
    public AjaxResult getOrderInfo(ByIdParam byIdParam) {

        try {
            //参数校验
            CheckFiledUtils.isFieldNull(byIdParam);
            return AjaxResult.success(awcOrderService.getOrderInfo(byIdParam.getId()));

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }
}