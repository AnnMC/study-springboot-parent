package study.springboot.elasticsearch.service;

import study.springboot.elasticsearch.EsModel.AccountModel;

/**
 * @author guyun
 * @package study.springboot.elasticsearch.service
 * @class AccountService
 * @date 2018/9/119:20
 * @description
 */
public interface AccountService {
    boolean add(AccountModel accountModel);

    AccountModel queryAccountModel(String userCode);
}