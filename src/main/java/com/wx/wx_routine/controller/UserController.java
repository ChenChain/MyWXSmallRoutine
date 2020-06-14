package com.wx.wx_routine.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wx.wx_routine.entity.User;
import com.wx.wx_routine.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 处理用户的路由
 *
 * @author 17596
 */
@Api(tags = "处理用户逻辑的路由")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @MethodName: getUserCode
     * @Description: TODO 获取用户的openId与sessionKey 新用户则更新到数据库 其他则返回用户对象
     * @Param: [code]
     * @Return:
     * @Author: chain
     * @Date: 2020/4/27
     **/
    @ApiOperation(value = "用户登录",notes = "登录时传递id")
    @GetMapping("/api/user/login")
    public User getUserCode(@RequestParam(value = "code", required = true) String code,
                            @RequestParam(value = "appId", required = true) String appId,
                            @RequestParam(value = "screctId", required = true) String screctId) {

        Map map = userService.getUserOpenIdSessionKey(code, appId, screctId);
        User user = userService.findUserByIdMap(map);
        if (user != null) {
            return user;
        } else {
            return userService.saveUserByIdMap(map);
        }
    }

    /**
     * @MethodName: updateUserInfo
     * @Description: TODO 解析User对象 因为WX的原因，要多一层解析JSON字符串
     * @Param: [user]
     * @Return: com.wx.wx_routine.entity.User
     * @Author: chain
     * @Date: 2020/4/28
    **/
    @ApiOperation(value = "用户更新信息",notes = "仅传递需要更新的字段即可，以user的JSON形式")
    @PostMapping("/api/user/update/")
    public User updateUserInfo(@RequestBody User  user){
//        JSONObject jsonObject=user.getJSONObject("user");
//        //更新后的user
//        User u= (User) JSONObject.parseObject(jsonObject.toJSONString(),User.class);
        return  userService.updateUserByOpenId(user);
    }


    @ApiOperation(value = "测试路由", notes = "这是一个测试路由，如果你可以使用，则代表能够正常访问该服务下的所有接口"  )
    @GetMapping("/api/test")
    public String test(){
        return "访问成功";
    }

}
