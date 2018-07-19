package com.study.springboot.jpa.controler;

import com.study.springboot.jpa.domin.UserDO;
import com.study.springboot.jpa.dto.UserDTO;
import com.study.springboot.jpa.schedule.UserAsynTask;
import com.study.springboot.jpa.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Andy
 * @Description TODO
 * @Date 2018/7/1 12:53
 */
@Api("用户相关处理")
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserAsynTask userAsynTask;


    @ApiOperation("根据用户ID用户信息")
    @RequestMapping(value = "/queryUserById/{id}", method = RequestMethod.GET)
    public UserDTO queryUserById(HttpServletRequest httpServletRequest,
                                 @ApiParam(name = "id", value = "id") @PathVariable("id") Long id,
                                 @ApiParam(name = "userId", value = "用户id") @RequestParam("userId") String userId) {
        String token = (String) httpServletRequest.getAttribute("token");
        System.out.println("token : " + token);
        UserDO userDO = userService.queryUserById(id);
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(userDO, dto);
        return dto;
    }

    @ApiOperation("根据用户姓名查询用户信息，分页查询")
    @ApiParam(name = "name", value = "用户姓名", required = true)
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<UserDO> list(@RequestParam("name") String name,
                             @RequestParam("size") Integer size,
                             @RequestParam("page") Integer page) {
        Pageable pageRequest = new QPageRequest(page, size);
        return userService.queryByUserName(name, pageRequest);
    }

    @ApiIgnore
    @ApiOperation("根据用户id删除数据")
    @ApiParam(name = "id", value = "用户id", required = true)
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
    public void delete(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    @ApiOperation("参数测试")
    @RequestMapping(value = "/list/{key}", method = RequestMethod.GET)
    public void list2(@ApiParam(value = "关键字") @PathVariable("key") String key, @RequestParam(value = "kw", required = false) String kw) {
        System.out.println(key);
        System.out.println(kw);
    }

    @ApiOperation("异步任务测试")
    @RequestMapping(value = "/asyn", method = RequestMethod.GET)
    public String asyn() {
        try {
            userAsynTask.doTaskOne();
            return "异步处理成功";
        } catch (Exception e) {
            return "异步处理失败";
        }
    }
}
