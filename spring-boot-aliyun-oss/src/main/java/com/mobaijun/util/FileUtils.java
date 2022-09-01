package com.mobaijun.util;

import org.springframework.web.multipart.MultipartFile;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/12/22 10:49
 * ClassName:FileUtils
 * 类描述： 文件工具类
 */
public class FileUtils {

    /**
     * 判断文件大小是否超过限制
     */
    public static boolean fileSize(MultipartFile uploadFile) {
        boolean flag = false;
        long fileSize = uploadFile.getSize();
        // 大小不能超过5MB
        if (fileSize >= (5000 * 1024)) {
            flag = true;
        }
        return flag;
    }
}
