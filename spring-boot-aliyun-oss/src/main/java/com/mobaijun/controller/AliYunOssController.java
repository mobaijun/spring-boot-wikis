package com.mobaijun.controller;

import cn.hutool.json.JSON;
import com.aliyun.oss.model.OSSObjectSummary;
import com.mobaijun.result.FileUploadResult;
import com.mobaijun.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/12/22 10:54
 * ClassName:AliYunOssController
 * 类描述：控制器
 */
@Api(description = "文件上传")
@RestController
@RequestMapping("/image")
public class AliYunOssController {

    @Resource
    private FileUploadService fileUploadService;

    @ApiOperation("文件上传")
    @PostMapping("file/upload")
    public Object upload(MultipartFile uploadFile) {
        FileUploadResult upload = this.fileUploadService.upload(uploadFile);
        return upload;
    }


    @ApiOperation("文件删除")
    @DeleteMapping("file/delete")
    public Object delete(String objectName) {
        FileUploadResult delete = this.fileUploadService.delete(objectName);
        return delete;
    }

    @ApiOperation("查看全部文件")
    @GetMapping("file/list")
    public Object list() {
        List<OSSObjectSummary> list = this.fileUploadService.list();
        return list;
    }

    @ApiOperation("文件下载")
    @GetMapping("file/download")
    public void download(String objectName, HttpServletResponse response) throws IOException {
        // 浏览器以附件形式下载
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(objectName.getBytes(), "ISO-8859-1"));
        this.fileUploadService.exportOssFile(response.getOutputStream(), objectName);
    }
}

