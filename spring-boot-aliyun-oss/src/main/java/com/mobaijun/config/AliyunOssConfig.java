package com.mobaijun.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/12/22 10:45
 * ClassName:AliyunOssConfig
 * 类描述： 阿里云配置类
 */
@Data
@Configuration
@ConfigurationProperties(prefix = AliyunOssConfig.PREFIX)
public class AliyunOssConfig {

    public static final String PREFIX = "aliyun.oss";

    /**
     * <a href="https://upload-images.jianshu.io/upload_images/5336514-2818153bf58ebfce.png">...</a>
     */
    private String bucketName;
    private String endpoint;
    private String accessKey;
    private String keySecret;
    private String fileHost;
    private String urlPrefix;

    @Bean
    public OSS oss() {
        return new OSSClient(endpoint, accessKey, keySecret);
    }
}
