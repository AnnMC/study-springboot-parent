package com.study.springboot.jpa.controler;

import com.study.springboot.jpa.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloWorldController {
    /**
     * JavaSE:
     *
     * @param str
     * @return
     */
    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input(String str) {
        // bean
        return helloWorldService.input(str);
    }


}
