package study.springboot.all.study.springboot.all.service;

import study.springboot.all.study.springboot.all.domain.AccountDO;

public interface AccountService {
    AccountDO queryById(Long id);

    AccountDO insertAccount(AccountDO accountDO);

    AccountDO queryByUserId(Long userId);
}
