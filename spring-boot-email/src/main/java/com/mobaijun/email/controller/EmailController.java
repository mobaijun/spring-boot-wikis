package com.mobaijun.email.controller;

import com.mobaijun.email.model.EmailSendInfo;
import com.mobaijun.email.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * software：IntelliJ IDEA 2022.1
 * class name: EmailController
 * class description：
 *
 * @author MoBaiJun 2022/10/28 14:29
 */
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class EmailController {

    private final EmailSenderService emailSenderService;

    @PostMapping("/senderEmail")
    public void senderEmail() {
        EmailSendInfo emailSendInfo = emailSenderService.sendMail("测试", "第一封邮件", false, "mobaijun8@163.com");
        System.out.println("emailSendInfo = " + emailSendInfo);
    }
}
