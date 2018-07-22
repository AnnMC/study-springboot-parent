package study.springboot.all.study.springboot.all.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @Author Andy
 * @Description //TODO
 * @Date xx$ xx$
 */
@NoRepositoryBean
public interface BaseResposity<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor {

}
