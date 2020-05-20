package com.wx.wx_routine.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * TODO
 *
 * @author chain
 * @date 2020/5/16
 */
@ApiModel(description = "发布订单信息实体")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPublishedInfo {
    @ApiModelProperty(value = "订单ID",example = "123")
    private Integer infoId;
    private String infoText;
    private Date infoStartTime;
    private Date infoEndTime;
    private Date infoPublishTime;
    private String infoUserOpenId;
    private String infoOfferMoney;
    private String infoTitle;
    private String infoUserName;
    private String infoUserPhone;
    private String infoUserAddress;
    private String infoExpressAddress;
    private String infoExpressId;
    private String infoExpressCompany;
    private String infoExpressAddressArea;
    private String infoUserRemark;
    //    该订单的状态 0-未接单 ，1-已接单未完成，2-已完成，3-过期或撤销
    @ApiModelProperty(value = "订单状态",example = "1")
    private Integer infoState;
}
