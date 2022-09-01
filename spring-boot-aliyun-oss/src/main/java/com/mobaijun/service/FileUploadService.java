package com.mobaijun.service;

import cn.hutool.core.date.DateTime;
import com.aliyun.oss.OSS;
import com.aliyun.oss.model.ListObjectsRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.OSSObjectSummary;
import com.aliyun.oss.model.ObjectListing;
import com.mobaijun.config.AliyunOssConfig;
import com.mobaijun.result.FileUploadResult;
import com.mobaijun.util.FileUtils;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Random;

import static com.mobaijun.constant.Constant.IMAGE_TYPE;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: <a href="https://www.mobaijun.com">...</a>
 * Date: 2021/12/22 10:51
 * ClassName:FileUploadService
 * 类描述：
 */
@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final OSS ossClient;
    private final AliyunOssConfig aliyunOssConfig;

    /**
     * 文件上传
     */
    public FileUploadResult upload(MultipartFile uploadFile) {
        // 校验图片格式
        boolean isLegal = false;
        for (String type : IMAGE_TYPE) {
            if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
                isLegal = true;
                break;
            }
        }
        // 封装Result对象，并且将文件的byte数组放置到result对象中
        FileUploadResult fileUploadResult = new FileUploadResult();
        if (!isLegal) {
            fileUploadResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return fileUploadResult;
        }
        // 判断文件大小是否超过限制
        boolean fileSize = FileUtils.fileSize(uploadFile);
        if (fileSize) {
            fileUploadResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return fileUploadResult;
        }
        // 文件新路径
        String fileName = uploadFile.getOriginalFilename();
        String filePath = getFilePath(fileName);
        // 上传到阿里云
        try {
            ossClient.putObject(aliyunOssConfig.getBucketName(), filePath, new ByteArrayInputStream(uploadFile.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
            // 上传失败
            fileUploadResult.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            return fileUploadResult;
        }
        fileUploadResult.setResponse(HttpStatus.OK);
        // 文件路径需要保存到数据库
        fileUploadResult.setUrl(this.aliyunOssConfig.getUrlPrefix() + filePath);
        fileUploadResult.setUid(String.valueOf(System.currentTimeMillis()));
        return fileUploadResult;
    }

    /**
     * 生成路径以及文件名
     */
    private String getFilePath(String sourceFileName) {
        DateTime dateTime = new DateTime();
        return this.aliyunOssConfig.getFileHost() + "/" + dateTime.toString("yyyy") + "/" + dateTime.toString("MM") + "/"
                + dateTime.toString("dd") + "/" + System.currentTimeMillis()
                + RandomUtils.nextInt(new Random().nextInt(), 9999) + "."
                + StringUtils.substringAfterLast(sourceFileName, ".");
    }

    /**
     * 查看文件列表
     */
    public List<OSSObjectSummary> list() {
        // 设置最大个数。
        final int maxKeys = 200;
        // 列举文件。
        ObjectListing objectListing = ossClient.listObjects(new ListObjectsRequest(aliyunOssConfig.getBucketName()).withMaxKeys(maxKeys));
        List<OSSObjectSummary> sums = objectListing.getObjectSummaries();
        return sums;
    }

    /**
     * 删除文件
     */
    public FileUploadResult delete(String objectName) {
        // 根据BucketName,objectName删除文件
        ossClient.deleteObject(aliyunOssConfig.getBucketName(), objectName);
        FileUploadResult fileUploadResult = new FileUploadResult();
        fileUploadResult.setUrl(objectName);
        fileUploadResult.setStatus(HttpStatus.LOOP_DETECTED);
        fileUploadResult.setResponse(HttpStatus.OK);
        return fileUploadResult;
    }

    /**
     * 下载文件
     */
    public void exportOssFile(OutputStream os, String objectName) throws IOException {
        // ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
        OSSObject ossObject = ossClient.getObject(aliyunOssConfig.getBucketName(), objectName);
        // 读取文件内容。
        BufferedInputStream in = new BufferedInputStream(ossObject.getObjectContent());
        BufferedOutputStream out = new BufferedOutputStream(os);
        byte[] buffer = new byte[1024];
        int lenght = 0;
        while ((lenght = in.read(buffer)) != -1) {
            out.write(buffer, 0, lenght);
        }
        out.flush();
        out.close();
        in.close();
    }
}
