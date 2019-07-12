package com.xiecl.myShop.commons.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyHttpClients {
    public static void main(String[] args) {
        System.out.println(doGet("http://127.0.0.1:8081/myshop-api/api/v1/contents/ppt"));
        List<BasicNameValuePair> list=new ArrayList<>();
        list.add(new BasicNameValuePair("username","123@qq.com"));
        list.add(new BasicNameValuePair("password","123"));

        String s = doPost("http://127.0.0.1:8081/myshop-api/api/v1/users/login", null, list.toArray(new BasicNameValuePair[list.size()]));
        System.out.println("123"+s);
    }

    public static final String REQUEST_GET="get";
    public static final String REQUEST_POST="post";
    public static final String REQUEST_HEADER_CONNECTION = "keep-alive";
    public static final String REQUEST_HEADER_USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Safari/537.36";
    public  static String doGet(String uri){
        return createHttpClient(REQUEST_GET,uri,null);
    }
    public  static String doGet(String uri,String cookie){
        return createHttpClient(REQUEST_GET,uri,cookie);
    }
    public  static String doPost(String uri,BasicNameValuePair... param){
        return createHttpClient(REQUEST_POST,uri,null,param);
    }
    public  static String doPost(String uri,String cookie,BasicNameValuePair... param){
        return createHttpClient(REQUEST_POST,uri,cookie,param);
    }


    public static String createHttpClient(String method, String uri, String cookie, BasicNameValuePair... param){
        //创建客户端
        CloseableHttpClient httpClient= HttpClients.createDefault();
        HttpResponse httpResponse=null;
        String result="";
        try {
            if(REQUEST_GET.equals(method)){
                //创建COOKIE连接
                HttpGet httpGet = new HttpGet(uri);
                httpGet.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                httpGet.setHeader("Cookie", cookie);
                httpGet.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                httpResponse=httpClient.execute(httpGet);
            }else if(REQUEST_POST.equals(method)){
                //创建COOKIE连接
                HttpPost httpPost = new HttpPost(uri);
                httpPost.setHeader("Connection", REQUEST_HEADER_CONNECTION);
                httpPost.setHeader("Cookie", cookie);
                httpPost.setHeader("User-Agent", REQUEST_HEADER_USER_AGENT);
                if(param != null && param.length > 0) {
                        httpPost.setEntity(new UrlEncodedFormEntity(Arrays.asList(param), "Utf-8"));
                }
                httpResponse = httpClient.execute(httpPost);
            }

            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(httpClient != null){
                try {
                    httpClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
