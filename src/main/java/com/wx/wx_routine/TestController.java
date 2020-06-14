package com.wx.wx_routine;

import com.wx.wx_routine.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/")
    public String test(){
        return "this is a test";
    }




}
