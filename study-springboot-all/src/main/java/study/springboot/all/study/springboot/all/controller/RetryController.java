package study.springboot.all.study.springboot.all.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import study.springboot.all.study.springboot.all.service.RetryService;

@RestController
@RequestMapping(value = "/v1/retry")
public class RetryController {

    @Autowired
    private RetryService retryService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT)
    public void add() {
        retryService.retry();
    }
}