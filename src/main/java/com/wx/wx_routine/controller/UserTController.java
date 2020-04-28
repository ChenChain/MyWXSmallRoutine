//package com.wx.wx_routine.controller;
//
//import com.wx.wx_routine.entity.User;
//import com.wx.wx_routine.error.NotFoundException;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
///**
// * 测试restfulAPI使用
// */
//@RestController
//@RequestMapping("/api/user")
//public class UserTController {
//
//    @Autowired
//    private UserService userService;
//
//    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
//    @GetMapping("/users")
//    @ResponseStatus(HttpStatus.OK)
//    public List<User> getUserList(){
//        return userService.getUserList();
//    }
//
//    @PostMapping("/users")
//    @ApiOperation(value = "添加用户",notes = "添加用户")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Object addUser(@RequestBody User user){
//        return  userService.addUser(user);
//    }
//
//
//    @GetMapping("/users/{id}")
//    @ApiOperation(value = "删除用户",notes = "根据id删除用户")
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Object getUser(@PathVariable("id")String id) throws NotFoundException {
////      Object o=null;
////        try {
////           o= userService.getUser(id);
////        }catch (Exception e){
//////            return o;
////            System.out.println("异常被捕获");
////        }
//          return userService.getUser(id) ;
//    }
//
//}
