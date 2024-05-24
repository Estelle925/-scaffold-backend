package com.yuanmeng.common.config;

import com.yuanmeng.common.lang.util.RestTemplateUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 海明
 * @since 2024/5/21
 * <p>
 *
 * </p>
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){
        return RestTemplateUtils.getRestTemplate(10,60000);
    }

}
