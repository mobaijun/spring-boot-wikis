package com.mobaijun.controller;

import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.common.Fonts;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Software：IntelliJ IDEA 2021.2 x64
 * Author: https://www.mobaijun.com
 * Date: 2022/1/10 17:22
 * ClassName:KaptchaController
 * 类描述：
 */
@RestController
@RequestMapping("/")
public class KaptchaController {


    /**
     * 生成验证码
     * 请求地址：http://localhost:7999/captcha
     */
    @GetMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) {
        HappyCaptcha.require(request, response)
                .style(CaptchaStyle.IMG)
                .type(CaptchaType.NUMBER)
                .length(4)
                .width(220)
                .height(80)
                .font(Fonts.getInstance().zhFont())
                .build()
                .finish();
    }

    /**
     * 校验验证码
     * 请求地址：http://localhost:7999/verify
     */
    @GetMapping("/verify")
    public String verify(String code, HttpServletRequest request) {
        // Verification Captcha
        boolean flag = HappyCaptcha.verification(request, code, true);
        if (flag) {
            // Other operations...
        }
        return null;
    }

    /**
     * 清理验证码
     * 请求地址：http://localhost:7999/remove/captcha
     */
    @GetMapping("/remove/captcha")
    public void removeCaptcha(HttpServletRequest request) {
        HappyCaptcha.remove(request);
    }
}
