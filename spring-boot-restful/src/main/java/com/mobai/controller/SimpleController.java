package com.mobai.controller;

import com.mobai.pojo.GoodsDo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * Software：IntelliJ IDEA 2021.1.1 x64
 * Author: https://www.mobaijun.com
 * Date: 2021/7/6 15:10
 * ClassName:SimpleController
 * 类描述： 测试类
 */
@Api(tags = {"API文档标签"})
@RestController
public class SimpleController {

    @ApiIgnore
    @GetMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }

    @ApiOperation(value = "welcome", produces = MediaType.TEXT_PLAIN_VALUE, notes = "返回：Hello swagger")
    @GetMapping("/welcome")
    public String home() {
        return "Hello, nice to meet you!";
    }

    @ApiOperation(value = "查询所有用户", produces = MediaType.TEXT_PLAIN_VALUE, notes = "返回：所有用户数据")
    @GetMapping("/user/all")
    public List<GoodsDo> getUserAll() {
        return null;
    }

    @ApiOperation(value = "根据id查询用户", produces = MediaType.TEXT_PLAIN_VALUE, notes = "返回：用户数据")
    @GetMapping("/user/{id}")
    public GoodsDo getUserById(@ApiParam(value = "用户id", required = true, example = "1") @PathVariable("id") Long id) {
        return null;
    }

    @ApiOperation(value = "保存用户", produces = MediaType.APPLICATION_JSON_VALUE, notes = "返回：新增用户id")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "access_token", value = "授权码", required = true, dataType = "string", paramType = "header", example = "abc"),
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "string", paramType = "query", example = "123456"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "参数填写错误"),
            @ApiResponse(code = 500, message = "接口异常")
    })
    @PostMapping("/user/save")
    public Long saveUser(@RequestBody GoodsDo user) {
        return 1L;
    }

    @ApiOperation(value = "根据id删除用户", produces = MediaType.TEXT_PLAIN_VALUE, notes = "无返回")
    @DeleteMapping("/user/delete")
    public void deleteUser(
            @ApiParam(value = "用户id", required = true, example = "1")
            @RequestParam("id") Long id) {
    }
}
