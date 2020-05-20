package com.wx.wx_routine.service.order;

import com.wx.wx_routine.entity.OrderPublishedInfo;

import java.util.List;

/**
 * TODO
 *
 * @author chain
 * @date 2020/5/16
 */
public interface OrderPublishService {

    /**
     * 发布订单 将信息保存到数据库中
     * @param orderPublishedInfo
     * @return
     */
    public int publishOrder(OrderPublishedInfo orderPublishedInfo);

    /**
     * 修改原有的订单
     * @param orderPublishedInfo
     * @return
     */
    int updateOrder(OrderPublishedInfo orderPublishedInfo);

    /**
     * 分页获取订单信息
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<OrderPublishedInfo> getOrderPublishedListWithoutDetails(Integer pageNum, Integer pageSize);

    /**
     * 根据id来删除订单
     * @param infoId
     * @return
     */
    Boolean delOrderPublishedOrder(int infoId);

    /**
     * 根据id来得到订单的详细信息
     * @param infoId
     * @return
     */
    OrderPublishedInfo getOrderPublishedInfoWithDetails(int infoId);


    OrderPublishedInfo getOrderPublishedInfoWithOutDetails(int infoId);


    /**
     * 评论订单
     * @return
     */
    boolean discussOrder(int infoId,int comment);

    /**
     * 完成订单
     * @return
     */
    boolean finishOrder(int infoId);


    /**
     * 接单者 评论订单
     * @return
     */
    boolean discussOrder_1(int infoId,int comment);

    /**
     *  接单者 完成订单
     * @return
     */
    boolean finishOrder_1(int infoId);
}
