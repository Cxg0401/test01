package com.cxg.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Data
@ConfigurationProperties(prefix = "mypage")
public class MyPageConfig {
    private Integer currentPage;
    private Integer pageSize;
}
