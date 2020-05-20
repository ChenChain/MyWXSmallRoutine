package com.wx.wx_routine.dao;

import com.wx.wx_routine.entity.OrderPublishedInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * TODO
 *
 * @author chain
 * @date 2020/5/16
 */
@Mapper
public interface OrderDao {

    int publishOrder(OrderPublishedInfo orderPublishedInfo);

    int updateOrder(OrderPublishedInfo orderPublishedInfo);

    List<OrderPublishedInfo> getOrderPublishedListWithoutDetails( Integer pageNum, Integer pageSize);

    int delOrderPublishedOrder(int  infoId);

    /**
     * 查询订单的状态
     * @param infoId
     * @return
     */
    Integer getOrderState(int infoId);

    OrderPublishedInfo getOrderPublishedInfoWithDetails(int infoId);

    OrderPublishedInfo getOrderPublishedInfoWithOutDetails(int infoId);


    /**
     * 发单者 评论订单
     * @return
     */
    int discussOrder(@Param("infoId") int infoId,@Param("comment") int comment);

    /**
     *  发单者 完成订单
     * @return
     */
    int finishOrder(int infoId);

    /**
     * 接单者 评论订单
     * @return
     */
    int discussOrder_1(@Param("infoId") int infoId,@Param("comment") int comment);

    /**
     *  接单者 完成订单
     * @return
     */
    int finishOrder_1(int infoId);


    /**
     * 接单
     * @return
     */
    boolean getOrder(int infoId);

    /**
     * 放弃订单 仅限误接单--10min内可操作
     * @return
     */
    boolean abandonOrder(int infoId);




}
