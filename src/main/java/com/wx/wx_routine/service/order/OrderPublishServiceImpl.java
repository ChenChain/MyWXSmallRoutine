package com.wx.wx_routine.service.order;

import com.github.pagehelper.PageHelper;
import com.wx.wx_routine.dao.OrderDao;
import com.wx.wx_routine.entity.OrderPublishedInfo;
import com.wx.wx_routine.exception.WXExpection;
import com.wx.wx_routine.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author chain
 * @date 2020/5/16
 */
@Service
public class OrderPublishServiceImpl implements OrderPublishService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public int publishOrder(OrderPublishedInfo orderPublishedInfo) {
        Date date= new Date();
        orderPublishedInfo.setInfoPublishTime(date);
        return orderDao.publishOrder(orderPublishedInfo);
    }

    @Override
    public int updateOrder(OrderPublishedInfo orderPublishedInfo) {
        orderPublishedInfo.setInfoStartTime(new Date());
        return orderDao.updateOrder(orderPublishedInfo);
    }

    @Override
    public List<OrderPublishedInfo> getOrderPublishedListWithoutDetails(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<OrderPublishedInfo> list=orderDao.getOrderPublishedListWithoutDetails(pageNum, pageSize);
        return list;
    }

    @Override
    public Boolean delOrderPublishedOrder(int infoId) {
        //如果该订单已经被接单 则无法删除
        Integer state=orderDao.getOrderState(infoId);
        if (state!=null&& state==1){
            throw  new WXExpection("该订单已经被接单，无法删除");
        }
        return orderDao.delOrderPublishedOrder(infoId)>0;
    }

    @Override
    public OrderPublishedInfo getOrderPublishedInfoWithDetails(int infoId) {
        return orderDao.getOrderPublishedInfoWithDetails(infoId);
    }

    @Override
    public OrderPublishedInfo getOrderPublishedInfoWithOutDetails(int infoId) {
        return orderDao.getOrderPublishedInfoWithOutDetails(infoId);
    }

    @Override
    public boolean discussOrder(int infoId,int comment) {
        return orderDao.discussOrder(infoId, comment)>0;
    }

    @Override
    public boolean finishOrder(int infoId) {
        return orderDao.finishOrder(infoId)>0;
    }



    @Override
    public boolean discussOrder_1(int infoId, int comment) {
        return orderDao.discussOrder_1(infoId,comment)>0;
    }

    @Override
    public boolean finishOrder_1(int infoId) {
        return orderDao.finishOrder_1(infoId)>0;
    }


}
