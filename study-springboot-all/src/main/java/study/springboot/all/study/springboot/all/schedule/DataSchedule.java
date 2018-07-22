package study.springboot.all.study.springboot.all.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import study.springboot.all.study.springboot.all.domain.AccountDO;
import study.springboot.all.study.springboot.all.domain.UserDO;
import study.springboot.all.study.springboot.all.service.AccountService;
import study.springboot.all.study.springboot.all.service.UserService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 定是任务处理类
 */
@Component
public class DataSchedule {
    private static Logger logger = LoggerFactory.getLogger(DataSchedule.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    /**
     * 初始化用户数据
     */
    @Scheduled(cron = "0 */1 * * * ?")
    public void initUserData() {
        logger.info("初始化用户数据处理");
        Random random = new Random();
        UserDO userDO = new UserDO();
        userDO.setUserName(random.nextInt() + "");
        userDO.setPassword(random.nextLong() + "");
        userDO.setAddress("北京");
        userService.insertUser(userDO);
    }

    /**
     * 初始化用户数据
     */
    @Scheduled(cron = "* */5 * * * ?")
    public void initAccountData() {
        logger.info("初始化账户数据处理");
        List<UserDO> list = userService.queryAll();
        if (CollectionUtils.isEmpty(list)) {
            logger.info("用户信息为空");
            return;
        }

        list.forEach(userDO -> {
            AccountDO accountDO = accountService.queryByUserId(userDO.getId());
            if (accountDO == null) {
                AccountDO insertAccountDO = new AccountDO();
                insertAccountDO.setUserDO(userDO);
                insertAccountDO.setBalance(BigDecimal.ONE);
                insertAccountDO.setName("中国银行");

                accountService.insertAccount(insertAccountDO);
            }
        });
    }
}
