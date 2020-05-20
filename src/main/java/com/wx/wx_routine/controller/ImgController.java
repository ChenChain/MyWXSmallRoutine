package com.wx.wx_routine.controller;

import com.wx.wx_routine.util.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

/**
 * TODO 处理图片相关路由
 *
 * @author chain
 * @date 2020/4/29
 */
@Api(tags = "图片上传")
@RestController
@RequestMapping("/img")
public class ImgController {

    /**
     * 图片本地保存目录
     */
    @Value("${imgPath}")
    private String path;

    /**
     * 返回图片的url的目录
     */
    @Value("${imgPathUrl}")
    private String pathURL;


    @ApiOperation(value = "图片上传",notes = "上传成功后返回服务端的图片地址")
    @PostMapping("/uploadImg")
    public String imgUpload(HttpServletRequest request, HttpServletResponse response,
                            @RequestParam(value = "file", required = false) MultipartFile file){
        String trueFileName=file.getOriginalFilename();
        String suffix=trueFileName.substring(trueFileName.lastIndexOf("."));
        String fileName="";
        String response_url="";
        try {
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type","text/html");

            fileName="date_"+ DateUtil.dateFormat(new Date(),"yyyy-MM-dd")+"_"+System.currentTimeMillis()+suffix;

            File filePath=new File(path);
            if (!filePath.exists()){
                filePath.mkdirs();
            }

            //保存图片到目录
            File f=new File(path+fileName);
            file.transferTo(f);

            StringBuilder stringBuilder = new StringBuilder(pathURL);
            stringBuilder.append(f.getName());

            response_url=stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response_url;
    }

}
