package study.springboot.elasticsearch.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import study.springboot.elasticsearch.EsModel.AccountModel;
import study.springboot.elasticsearch.service.AccountService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

@SpringBootTest
@RunWith(value = SpringRunner.class)
public class AccountServiceImplTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void add() {
        for (int i = 100000; i < 1000002; i++) {
            AccountModel accountModel = new AccountModel();

            accountModel.setId(Long.valueOf(i));
            accountModel.setAccountCode(i * 2 + "");
            accountModel.setAccountName("余额");
            accountModel.setUserCode(i * 3 + "");
            accountModel.setUserName(i * 5 + "");
            accountModel.setCreateTime(new Date());
            accountModel.setUpdateTime(new Date());
            accountModel.setIsActive(Boolean.TRUE);
            accountModel.setBalance(BigDecimal.valueOf(new Random().nextInt(4000)));

            System.out.println("是否插入成功" + accountService.add(accountModel));
        }
    }

    @Test
    public void queryAccountModel() {
        AccountModel accountModel = accountService.queryAccountModel("21232");
        System.out.println(accountModel.toString());
    }
}