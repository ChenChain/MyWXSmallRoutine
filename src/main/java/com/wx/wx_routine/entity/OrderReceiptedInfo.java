package com.wx.wx_routine.entity;

import com.sun.org.apache.xpath.internal.operations.Bool;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *  接单信息表
 * @author chain
 * @date 2020/5/16
 */
@ApiModel("接单信息实体")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderReceiptedInfo {
    @ApiModelProperty(value = "订单状态",example = "1")
    private Integer receiptId;
    private String receiptUserOpenId;
    private String receiptedUserOpenId;
    private String receiptStartTime;
    private String receiptEndTime;
    private Boolean receiptedUserFinished;
    private Boolean receiptUserFinished;
    private Integer receiptUserComment;
    private Integer receiptedUserComment;
}
