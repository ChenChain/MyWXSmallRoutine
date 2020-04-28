package com.wx.wx_routine.service;

import com.alibaba.fastjson.JSONObject;
import com.wx.wx_routine.dao.UserDao;
import com.wx.wx_routine.entity.User;
import com.wx.wx_routine.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *
 * @author chain
 * @date 2020/4/27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public Map<String, String> getUserOpenIdSessionKey(String code, String aId, String seId) {
        Map<String, String> map = new HashMap<>(16);
        String params = "appid=" + aId + "&secret=" + seId + "&js_code=" + code;
        String str = HttpUtil.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
        JSONObject jsonObject = JSONObject.parseObject(str);

        String session_key = jsonObject.getString("session_key");
        String openid = jsonObject.getString("openid");

        map.put("openid", openid);
        map.put("session_key", session_key);
        return map;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public User saveUserByIdMap(Map<String, String> map) {
        userDao.saveUserByIdMap(map);
        return userDao.findUserById(map.get("openid"));
    }

    @Override
    public User findUserByIdMap(Map<String, String> map) {
        return userDao.findUserById(map.get("openid"));
    }

    @Override
    public User updateUserByOpenId(User user) {
        userDao.updateUserByOpenId(user);
        return userDao.findUserById(user.getUser_openid());
    }
}
