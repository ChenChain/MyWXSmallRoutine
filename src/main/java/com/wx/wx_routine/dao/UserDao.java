package com.wx.wx_routine.dao;

import com.wx.wx_routine.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

/**
 * TODO
 *
 * @author chain
 * @date 2020/4/27
 */
@Mapper
public interface UserDao {

    /**
     * 保存用户
     * @param user
     * @return
     */
    User saveUser(User user);

    /**
     * 更改用户信息
     * @param user
     * @return
     */
     int updateUserByOpenId(User user);

    /**
     * 根据id来查找用户
     * @param openid
     * @return
     */
    User findUserById(String openid);

    /**
     * 根据id来删除用户
     * @param openid
     * @return
     */
    void deleteUser(int openid);

    /**
     * 通过map来保存User 仅保存SessionKey openid
     * @param map
     * @return
     */
    void saveUserByIdMap(Map<String, String> map);
}
