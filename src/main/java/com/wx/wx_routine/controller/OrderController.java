package com.wx.wx_routine.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.wx.wx_routine.constant.InfoConstant;
import com.wx.wx_routine.entity.OrderPublishedInfo;
import com.wx.wx_routine.exception.WXExpection;
import com.wx.wx_routine.service.order.OrderPublishService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO
 * 订单发布的controller
 * @author chain
 * @date 2020/5/16
 */

@Api(tags = "用户订单与订单任务")
@RestController
@RequestMapping("/api/order/")
public class OrderController {

    @Autowired
    private OrderPublishService orderPublishService;

    @ApiOperation(value = "发布订单任务")
    @PostMapping("publish")
    public String publishOrder(@RequestBody OrderPublishedInfo orderPublishedInfo){
        return orderPublishService.publishOrder(orderPublishedInfo)>0?"发布成功":"发布失败";
    }

    @ApiOperation(value = "更新订单任务")
    @PostMapping("update")
    public String updateOrder(@RequestBody OrderPublishedInfo orderPublishedInfo){
        return orderPublishService.updateOrder(orderPublishedInfo)>0?"更新成功":"更新失败";
    }

    @GetMapping("query/{pageNum}/{pageSize}")
    @ApiOperation(value ="获取订单任务列表",notes = "只依靠简单的分页来获取信息,并且这类信息对外公开且隐藏用户隐私（待界面原型后完善）")
    public List<OrderPublishedInfo> getOrderPublishedListWithoutDetails( @ApiParam("页码")@PathVariable("pageNum") Integer pageNum,
                                                                         @ApiParam("大小")@PathVariable("pageSize") Integer pageSize){
        return orderPublishService.getOrderPublishedListWithoutDetails(pageNum, pageSize);
    }
    @ApiOperation(value = "查询单个订单任务", notes = "此查询为详细查询，携带用户的隐私数据")
    @GetMapping("query/{infoId}")
    public OrderPublishedInfo getOrderPublishedInfoWithDetails( @PathVariable("infoId") @ApiParam("订单任务编号")Integer infoId){
        return orderPublishService.getOrderPublishedInfoWithDetails(infoId);
    }

    @ApiOperation(value = "查询单个订单任务", notes = "此查询不携带用户的隐私数据")
    @GetMapping("query/normal/{infoId}")
    public OrderPublishedInfo getOrderPublishedInfoWithOutDetails( @PathVariable("infoId") @ApiParam("订单任务编号")  Integer infoId) {
        return orderPublishService.getOrderPublishedInfoWithOutDetails(infoId);
    }

    @ApiOperation(value = "删除用户发布的订单", notes = "仅限删除前仍未被接单的或者过期的，已完成的不删除")
    @GetMapping("delete/{infoId}")
    public Boolean delOrderPublishedOrder( @PathVariable("infoId") @ApiParam("订单任务编号") Integer infoId){
        return orderPublishService.delOrderPublishedOrder(infoId);
    }

    @GetMapping("complete/{infoId}/{person}")
    @ApiOperation(value = "完成订单",notes = "person=0时为发布订单者确认，=1时为接单者确认")
    public  Boolean finishOrder (@PathVariable("infoId") @ApiParam("infoId 订单号")  Integer infoId,
                                 @PathVariable("person") @ApiParam("0--发布订单者 1--接单者") Integer person){
            if (person==0){
                return  orderPublishService.finishOrder(infoId);
            }else {
                return orderPublishService.finishOrder_1(infoId);
            }
    }

    @GetMapping("comment/{infoId}/{person}/{level}")
    @ApiOperation(value = "评论订单",notes = "person=0时为发布订单者评论，=1时为接单者评论")
    public Boolean commentOrder(@PathVariable("infoId") @ApiParam("infoId 订单号")  Integer infoId,
                                @PathVariable("person") @ApiParam("0--发布订单者 1--接单者") Integer person,
                                @PathVariable("level") @ApiParam("level 评论1，2，3")   Integer level  ){
        if (person==0){
            return orderPublishService.discussOrder(infoId,level);
        }
        return orderPublishService.discussOrder_1(infoId,level);
    }

    @ApiOperation("用户接单")
    @GetMapping("/receive/{openid}/{infoId}")
    public Boolean receiveOrder(@PathVariable("openid") @ApiParam("接单者openid") String openId,
                                @PathVariable("infoId") @ApiParam("订单id") Integer infoId){

        throw new WXExpection("暂未开发");
    }

    @GetMapping("/abandon/{infoId}")
    @ApiOperation("接单用户取消接单，仅限10分钟内")
    public Boolean abandonOrder(@PathVariable("infoId") @ApiParam("订单id") Integer infoId){
        throw  new      WXExpection("暂未开发");
    }





}
