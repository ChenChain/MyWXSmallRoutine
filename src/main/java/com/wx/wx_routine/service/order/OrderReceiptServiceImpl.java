package com.wx.wx_routine.service.order;

import org.springframework.stereotype.Service;

/**
 * TODO
 * 接单相关逻辑
 * @author chain
 * @date 2020/5/19
 */
@Service
public class OrderReceiptServiceImpl implements  OrderReceiptService {

    @Override
    public boolean getOrder(int infoId) {
        return false;
    }

    @Override
    public boolean abandonOrder(int infoId) {
        return false;
    }


    @Override
    public boolean discussOrder() {
        return false;
    }

    @Override
    public boolean finishOrder() {
        return false;
    }
}
