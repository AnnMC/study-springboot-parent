package study.springboot.all.study.springboot.all.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import study.springboot.all.study.springboot.all.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.Future;

/**
 * 线程池处理
 */
@RestController
@RequestMapping(value = "/v1/thread")
public class ThreadController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/exeThread", method = RequestMethod.GET)
    public void exeThread(HttpServletRequest request) {
        Future future = SdExecutors.getSdThreadPoolExecutor().submit(() -> userService.queryAll());
    }
}
