package com.azj.video.dbzyw;

import com.azj.video.http.DbzywHttp;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * 等待最帅的添加描述
 *
 * @author zzw zengzhiwei_hfut@163.com
 * @see 等待最帅的添加
 * @since 2019/5/19 0019-17:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
@Slf4j
public class TestDbzywHttp {

    @Value("${dbzyw.sort.url}")
    private String sortUrl;

    @Value("${dbzyw.resource.url}")
    private String resourceUrl;

    @Autowired
    private DbzywHttp dbzywHttp;

    @Test
    public void testGetSort() throws IOException {
        String sort = dbzywHttp.httpGet(sortUrl);
        String resource = dbzywHttp.httpGet(resourceUrl);
        log.info("sort=={}", sort);
        log.info("resource=={}", resource);
    }
}
