package study.springboot.all.study.springboot.all.reposity;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import study.springboot.all.study.springboot.all.domain.AccountDO;

@Repository
public interface AccountReposity extends BaseResposity<AccountDO, Long> {
    @Query(value = "select * from t_account t where t.user_id =:userId ", nativeQuery = true)
    AccountDO queryByUserId(@Param("userId") Long userId);
}
