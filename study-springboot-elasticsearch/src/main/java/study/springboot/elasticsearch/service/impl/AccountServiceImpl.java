package study.springboot.elasticsearch.service.impl;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.springboot.elasticsearch.EsModel.AccountModel;
import study.springboot.elasticsearch.reposity.AccountReposity;
import study.springboot.elasticsearch.service.AccountService;

import java.util.Iterator;

/**
 * @author guyun
 * @package study.springboot.elasticsearch.service
 * @class AccountServiceImpl
 * @date 2018/9/119:21
 * @description
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    private static Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private AccountReposity accountReposity;

    @Override
    public boolean add(AccountModel accountModel) {
        try {
            accountReposity.save(accountModel);
        } catch (Exception e) {
            logger.info(ExceptionUtils.getStackTrace(e));
            return false;
        }
        return true;
    }

    @Override
    public AccountModel queryAccountModel(String userCode) {
        QueryStringQueryBuilder queryStringQueryBuilder = new QueryStringQueryBuilder(userCode);

        Iterable<AccountModel> iterable = accountReposity.search(queryStringQueryBuilder);
        Iterator<AccountModel> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            return iterator.next();
        }
        return null;
    }
}