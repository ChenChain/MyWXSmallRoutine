package com.wx.wx_routine.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author chain
 * @date 2020/4/27
 */
public class HttpUtil {

    /** 
     * @MethodName:
     * @Description: TODO 向指定的url发送请求
     * @Param: [url, param]
     * @Return: java.lang.String
     * @Author: chain
     * @Date: 2020/4/27
    **/
    public static String sendGet(String url,String param){
        String result="";
        BufferedReader in=null;
        try {
            String urlNameString=url+"?"+param;
            URL realUrl=new URL(urlNameString);
            //打开连接
            URLConnection connection=realUrl.openConnection();
            connection.setRequestProperty("accept","*/&");
            connection.setRequestProperty("connection","Keep-Alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.connect();
            //获取响应头字段
            Map<String, List<String>> map=connection.getHeaderFields();

            in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line=in.readLine())!=null){
                result +=line;
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (in!=null){
                    in.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
