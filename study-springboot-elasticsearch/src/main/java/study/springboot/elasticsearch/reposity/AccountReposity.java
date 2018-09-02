package study.springboot.elasticsearch.reposity;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import study.springboot.elasticsearch.EsModel.AccountModel;

/**
 * @author guyun
 * @package study.springboot.elasticsearch.reposity
 * @class AccountReposity
 * @date 2018/9/119:16
 * @description
 */
public interface AccountReposity extends ElasticsearchRepository<AccountModel, Long> {
}