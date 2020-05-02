package com.wx.wx_routine.controller;

import com.wx.wx_routine.util.DateUtil;
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



    @ResponseBody
    @RequestMapping("/test")
    public String  test(){
        return "test";
    }

    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {

        System.out.println(11111);
        String imgPathToSave="";
        System.out.println("执行upload");
        request.setCharacterEncoding("UTF-8");
        System.out.println("执行图片上传");

        if (!file.isEmpty()) {
            System.out.println("成功获取照片");
            String fileName = file.getOriginalFilename();
            String path = null;
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            System.out.println("图片初始名称为：" + fileName + " 类型为：" + type);
            if (type != null) {
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {
                    // 项目在容器中实际发布运行的根路径
                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = realPath + "/uploads/" + trueFileName;
                    System.out.println("存放图片文件的路径:" + path);
                    file.transferTo(new File(path));
                    System.out.println("文件成功上传到指定目录下");
                } else {
                    System.out.println("不是我们想要的文件类型,请按要求重新上传");
                    return "error";
                }
            } else {
                System.out.println("文件类型为空");
                return "error";
            }
        } else {
            System.out.println("没有找到相对应的文件");
            return "error";
        }
        return "success";
    }



    @RequestMapping("/uploadImg")
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
