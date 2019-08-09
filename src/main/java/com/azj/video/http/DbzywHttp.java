package com.azj.video.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.io.IOException;

/**
 * 获取豆瓣资源网的资源视频
 *
 * @author zzw zengzhiwei_hfut@163.com
 * @see HttpClients
 * @since 2019/5/19 0019-14:35
 */
@Slf4j
@Component
public class DbzywHttp {

    /**
     * 豆瓣资源网分类地址
     */
    @Value("${dbzyw.sort.url}")
    private String sortUrl;

    @Value("dbzyw.resource.url")
    private String resourceUrl;


    public String httpGet(String url) throws IOException {
        CloseableHttpResponse response = null;
        CloseableHttpClient client = null;
        try {
            // 建立get请求
            HttpGet httpGet = new HttpGet(url);
            // 创建client
            client = HttpClients.createDefault();
            // 执行
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(entity);
            }
            return null;
        }finally {
            if (client != null){
                client.close();
            }
            if (response != null){
                response.close();
            }
        }

    }
}
