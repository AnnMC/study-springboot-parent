package study.springboot.all.study.springboot.all.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.springboot.all.study.springboot.all.domain.AccountDO;
import study.springboot.all.study.springboot.all.reposity.AccountReposity;
import study.springboot.all.study.springboot.all.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountReposity accountReposity;

    @Override
    public AccountDO queryById(Long id) {
        return accountReposity.getOne(id);
    }

    @Override
    public AccountDO insertAccount(AccountDO accountDO) {
        return accountReposity.save(accountDO);
    }

    @Override
    public AccountDO queryByUserId(Long userId) {
        return accountReposity.queryByUserId(userId);
    }
}
