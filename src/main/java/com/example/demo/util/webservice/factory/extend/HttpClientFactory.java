package com.example.demo.util.webservice.factory.extend;

import com.example.demo.util.webservice.Data.ReqData;
import com.example.demo.util.webservice.factory.WebServiceFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;

/**
 * @author: topsnowwolf
 * @description: HttpClient处理工厂
 * @date: Create in 2018/8/17 21:32
 * @modified by:
 * @versions：0.1.0
 */
public class HttpClientFactory extends WebServiceFactory {
    private final static Logger logger = LoggerFactory.getLogger(HttpClientFactory.class);
    // 请求超时时间
    public static int socketTimeout = 30000;
    // 响应超时时间
    public static int connectTimeout = 30000;
    @Override
    public String sendWebService(ReqData reqData) {
        String retStr = "";
        // 创建HttpClientBuilder
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        // HttpClient
        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();
        HttpPost httpPost = new HttpPost(reqData.getUrl());
        //  设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        httpPost.setConfig(requestConfig);
        try {
            httpPost.setHeader("Content-Type", "text/xml;charset=UTF-8");
            httpPost.setHeader("SOAPAction", "");
            StringEntity data = new StringEntity(reqData.getParam(),Charset.forName("UTF-8"));
            httpPost.setEntity(data);
            CloseableHttpResponse response = closeableHttpClient.execute(httpPost);
            HttpEntity httpEntity = response.getEntity();
            if (httpEntity != null) {
                // 打印响应内容
                retStr = EntityUtils.toString(httpEntity, "UTF-8");
                logger.info("response:" + retStr);
            }
            // 释放资源
            closeableHttpClient.close();
        } catch (Exception e) {
            logger.error("exception in sendPostDataByXml", e);
        }
        return retStr;
    }
}
