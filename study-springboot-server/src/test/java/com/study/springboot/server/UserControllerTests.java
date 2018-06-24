package com.study.springboot.server;

import com.study.springboot.controller.UserController;
import com.study.springboot.email.MailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTests {
    @Autowired
    private MockMvc mockMvc;

    //初始化工作
    @Before
    public void setUp() {
        //独立安装测试
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
        //集成Web环境测试（此种方式并不会集成真正的web环境，而是通过相应的Mock API进行模拟测试，无须启动服务器）
        //mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void hello1() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=lili"))
                .andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.content().string("Hi:lili"));  //测试接口返回内容
        mockMvc.perform(MockMvcRequestBuilders.get("/hello?name=lili"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

}
