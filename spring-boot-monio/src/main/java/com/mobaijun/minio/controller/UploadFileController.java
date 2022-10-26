package com.mobaijun.minio.controller;

import com.mobaijun.minio.exception.MinioException;
import com.mobaijun.minio.util.MinioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: UploadFileController
 * class description： 测试
 *
 * @author MoBaiJun 2022/10/26 16:02
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/file-upload")
public class UploadFileController {

    /**
     * 构造注入
     */
    private final MinioService minioService;

    @PostMapping("/upload")
    public void upload(@RequestParam(name = "multipartFile") MultipartFile multipartFile) throws IOException, MinioException {
        minioService.upload(Paths.get(Objects.requireNonNull(multipartFile.getOriginalFilename())), multipartFile.getInputStream(), "image/jpeg");
    }
}
