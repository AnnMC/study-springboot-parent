package com.study.springboot.jpa.service.impl;

import com.study.springboot.jpa.service.MenuItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MenuItemServiceImplTest {

    @Autowired
    private MenuItemService menuItemService;

    @Test
    public void processMenuItem() {
        String menu = menuItemService.processMenuItem();
        System.out.println(menu);
    }
}