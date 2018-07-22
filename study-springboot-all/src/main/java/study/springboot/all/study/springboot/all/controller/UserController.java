package study.springboot.all.study.springboot.all.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import study.springboot.all.study.springboot.all.content.ResponseContent;
import study.springboot.all.study.springboot.all.exception.BizException;
import study.springboot.all.study.springboot.all.service.UserService;
import study.springboot.all.study.springboot.all.vo.UserVo;

/**
 *
 */
@RestController
@RequestMapping(value = "/v1/user")
public class UserController {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryById/{id}", method = RequestMethod.GET)
    public ResponseContent<UserVo> queryById(@RequestParam("id") Long id) {
        UserVo userVo = userService.queryById(id);
        return ResponseContent.buildSuccess(null, userVo);
    }
    
    @RequestMapping(value = "/handleException", method = RequestMethod.GET)
    public ResponseContent<UserVo> handleException() {
        return ResponseContent.buildSuccess(null, userService.handleException(true));
    }
}
