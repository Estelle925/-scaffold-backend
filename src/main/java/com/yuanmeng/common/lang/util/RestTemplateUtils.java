package com.yuanmeng.common.lang.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * Author: 海明
 * Created: 2024/05/21
 * Description:
 * @author chenhaiming
 */
@Slf4j
public class RestTemplateUtils {
    public static RestTemplate getRestTemplate(int maxTotal, int timeout) {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = httpComponentsClientHttpRequestFactory(maxTotal, timeout);
        return new RestTemplate(httpRequestFactory);
    }

    /**
     * ClientHttpRequestFactory接口的另一种实现方式（推荐使用），即：
     * HttpComponentsClientHttpRequestFactory：底层使用Httpclient连接池的方式创建Http连接请求
     */
    private static HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory(int maxTotal, int timeout) {
        //Httpclient连接池，长连接保持时间
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(1, TimeUnit.HOURS);
        //设置总连接数
        connectionManager.setMaxTotal(maxTotal);
        //设置同路由的并发数
        connectionManager.setDefaultMaxPerRoute(maxTotal);
        //设置header
        List<Header> headers = new ArrayList<>();
        headers.add(new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.3; rv:36.0) Gecko/20100101 Firefox/36.04"));
        headers.add(new BasicHeader("Accept-Encoding", "gzip, deflate"));
        headers.add(new BasicHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3"));
        headers.add(new BasicHeader("Connection", "keep-alive"));
        //创建HttpClient
        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connectionManager)
                .setDefaultHeaders(headers)
                //设置重试次数
                .setRetryHandler(new DefaultHttpRequestRetryHandler(3, true))
                //设置保持长连接
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())
                .build();
        //创建HttpComponentsClientHttpRequestFactory实例
        HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
        //设置客户端和服务端建立连接的超时时间
        requestFactory.setConnectTimeout(timeout);
        //设置客户端从服务端读取数据的超时时间
        requestFactory.setReadTimeout(5000);
        //设置从连接池获取连接的超时时间，不宜过长
        requestFactory.setConnectionRequestTimeout(2000);
        //缓冲请求数据，默认为true。通过POST或者PUT大量发送数据时，建议将此更改为false，以免耗尽内存
        requestFactory.setBufferRequestBody(false);
        return requestFactory;
    }
}

