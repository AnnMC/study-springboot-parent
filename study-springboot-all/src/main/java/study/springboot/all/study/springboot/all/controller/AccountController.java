package study.springboot.all.study.springboot.all.controller;

import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping(value = "/v1/account")
public class AccountController {
    private static Logger logger = LoggerFactory.getLogger(AccountController.class);

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET)
    public String sayHello(@ApiParam(value = "信息") @RequestParam("mess") String mess) {
        return "hi," + mess;
    }
}
