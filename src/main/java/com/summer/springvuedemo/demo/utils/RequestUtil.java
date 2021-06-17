package com.summer.springvuedemo.demo.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestUtil {
    public String get(String url) {

        // 存储返回的字符串
        String data = "";
        try {
            URL urlObject = new URL(url);
            System.out.println("请求地址："+url);
            //开发访问此连接
            HttpURLConnection urlConn = (HttpURLConnection) urlObject.openConnection();
            //设置连接时间为5秒
            urlConn.setConnectTimeout(5 * 10000);
            //设置读取时间为5秒
            urlConn.setReadTimeout(5 * 10000);
            // 设置是否向httpUrlConnection输出，因为这个是get请求，参数要放在
            // http正文内，因此需要设为true, 默认情况下是false;
            urlConn.setDoOutput(true);
            // 设置是否从httpUrlConnection读入，默认情况下是true;
            urlConn.setDoInput(true);
            // Get 请求不能使用缓存
            urlConn.setUseCaches(false);
            // 设定传送的内容类型是可序列化的java对象,setRequestProperty的信息都是设置在head头里面
            // (如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException)
            urlConn.setRequestProperty("User-agent", "Mozilla/5.0 (Windows NT 5.1) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.215 Safari/535.1");
            urlConn.setRequestProperty("token", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJrdGJpIiwicm9sZSI6IlJPTEVfVVNFUiIsImlzcyI6InRjbGVyIiwiZXhwIjoxNTk5ODA3Mzc5LCJpYXQiOjE1OTkyMDI1Nzl9.IciVkGcsYfD9hDacV4-lKkGFft-Z-LnEkmYtcDlPjYeN2styo3IA6dbE0JP08bmy8uS8sy3TL_65_fTbEoilow");
            urlConn.setRequestProperty("Content-type", "application/x-java-serialized-object");
            int code = urlConn.getResponseCode();//获得相应码
            System.out.println("请求响应码:"+ code);
            // 设置所有的http连接是否自动处理重定向；设置成true，系统自动处理重定向
            urlConn.setInstanceFollowRedirects(true);
            //得到数据流（输入流）
            InputStream is = urlConn.getInputStream();
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = is.read(buffer)) != -1) {
                String str = new String(buffer, 0, length);
                data += str;
            }
            System.out.println("请求页面：");
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
