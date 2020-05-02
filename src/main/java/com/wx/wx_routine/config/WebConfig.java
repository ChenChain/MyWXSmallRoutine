package com.wx.wx_routine.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO
 *  配置图片资源可以被访问
 * @author chain
 * @date 2020/5/2
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer {

    /**
     * 图片的存储目录
     */
    @Value("${imgPath}")
    private String imgpath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //配置静态资源可以被访问
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");

        //配置图片资源目录 路径
        registry.addResourceHandler("/wx_imgs/**").addResourceLocations("file:"+imgpath);
    }
}
