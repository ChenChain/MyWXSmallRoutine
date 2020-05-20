package com.wx.wx_routine.service.order;

import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author chain
 * @date 2020/5/19
 */
@Service
public interface OrderReceiptService {

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

    /**
     * 已经在publish中实现
    * 评论订单
     * @return
     */
    boolean discussOrder();

    /**
     *      * 已经在publish中实现
     * 完成订单
     * @return
     */
    boolean finishOrder();


}
