package study.springboot.all.study.springboot.all.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.springboot.all.study.springboot.all.content.ResponseContent;
import study.springboot.all.study.springboot.all.email.MailService;
import study.springboot.all.study.springboot.all.exception.BizException;

import javax.servlet.http.HttpServletRequest;

/**
 *
 */
@RestController
@RequestMapping(value = "/v1/email")
public class EmailController {
    private static Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public ResponseContent<String> send() {
        mailService.sendSimpleMail("2452008648@qq.com", "SpringBoot邮件测试", "SpringBoot邮件测试");
        return ResponseContent.buildSuccess("发送成功");
    }

    @ApiOperation(value = "国际化测试")
    @RequestMapping(value = "/guojihua", method = RequestMethod.GET)
    public ResponseContent<String> guojihua(HttpServletRequest request) {
        throw new BizException("message");
    }
}
