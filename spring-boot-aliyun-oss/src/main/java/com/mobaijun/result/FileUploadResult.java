package com.mobaijun.result;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/12/22 10:52
 * ClassName:FileUploadResult
 * 类描述：返回信息
 */
@Data
public class FileUploadResult {

    /**
     * 文件唯一标识
     */
    private String uid;
    /**
     * 文件地址
     */
    private String url;
    /**
     * 状态
     */
    private HttpStatus status;
    /**
     * 服务端响应内容
     */
    private HttpStatus response;
}
