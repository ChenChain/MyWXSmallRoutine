package com.wx.wx_routine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author chain
 * @date 2020/4/27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    /**
     * 主键
     */
    private Integer user_id;

    /**
     * openid 表示唯一的微信用户
     */
    private String user_openid;

    /**
     * 用户昵称
     */
    private String user_nickname;

    /**
     * 用户真实姓名
     */
    private String user_realname;

    /**
     * 用户的学号
     */
    private String user_schoolid;

    /**
     * 学校
     */
    private String user_school;
    /**
     * 学院
     */
    private String user_college;

    /**
     * 用户手机号
     */
    private String user_phonenumber;

    /**
     * 用户地址
     */
    private String user_address;

    /**
     * 学生证地址
     */
    private String user_studentidcard_url;

    /**
     * 学生卡地址
     */
    private String user_studentcard_url;

}
