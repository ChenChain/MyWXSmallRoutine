package com.wx.wx_routine.service;

import com.wx.wx_routine.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * TODO
 *
 * @author chain
 * @date 2020/4/27
 */
@Service
public interface UserService {

    /** 
     * @MethodName: getUserOpenIdSessionKey
     * @Description:  获得id
     * @Param: [code, aId, seId]
     * @Return: java.util.Map<java.lang.String,java.lang.String>
     * @Author: chain
     * @Date: 2020/4/27
    **/
    public Map<String, String> getUserOpenIdSessionKey(String code,String aId,String seId);

    /** 
     * @MethodName: saveUserByIdMap
     * @Description: TODO 根据userMap去保存新用户
     * @Param: [map]
     * @Return: com.wx.wx_routine.entity.User
     * @Author: chain
     * @Date: 2020/4/27
    **/
    public User saveUserByIdMap(Map<String,String> map);


    /**
     * @MethodName: findUserByIdMap
     * @Description: TODO 通过usermap去检索当前用户是否存在 如果存在 则返回当前用户信息
     * @Param: [map]
     * @Return: com.wx.wx_routine.entity.User
     * @Author: chain
     * @Date: 2020/4/27
    **/
    public User findUserByIdMap(Map<String,String> map);

    /**
     * @MethodName: updateUserByOpenId
     * @Description: TODO 根据传入的user的ip去更新它,并返回新的User对象
     * @Param: [user]
     * @Return: int
     * @Author: chain
     * @Date: 2020/4/28
    **/
    public User updateUserByOpenId(User user);



}
