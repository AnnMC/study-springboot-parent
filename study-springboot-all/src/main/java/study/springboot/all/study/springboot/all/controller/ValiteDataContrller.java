package study.springboot.all.study.springboot.all.controller;

import com.zaxxer.hikari.util.FastList;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import study.springboot.all.study.springboot.all.dto.ValiteData;

import java.util.List;

/**
 * SpringBoot 数据验证
 */
@RestController
@RequestMapping(value = "/v1/valite")
public class ValiteDataContrller {
    @RequestMapping(value = "/handleData", method = RequestMethod.POST)
    public String handleData(@RequestBody @Validated ValiteData param) {

        List<String> fastList = new FastList(String.class);
        fastList.add("xx");
        return param.getEmail();
    }
}
