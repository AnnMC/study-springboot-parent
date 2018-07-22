package study.springboot.all.study.springboot.all.reposity;

import org.springframework.stereotype.Repository;
import study.springboot.all.study.springboot.all.domain.AccountDO;
import study.springboot.all.study.springboot.all.domain.UserDO;

@Repository
public interface UserReposity extends BaseResposity<UserDO, Long> {
}
