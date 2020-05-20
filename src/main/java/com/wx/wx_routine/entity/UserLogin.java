package com.wx.wx_routine.entity;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TODO
 *  用户登录状态记录
 * @author chain
 * @date 2020/5/16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLogin {
    private Integer user_id;
    private String user_sessionkey;
    private String user_openid;
    /**
     * 登录状态
     * 1--登录中
     * 0--未登录
     */
    private Integer state;
}