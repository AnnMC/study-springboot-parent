package study.springboot.all.study.springboot.all.service;

import study.springboot.all.study.springboot.all.domain.UserDO;
import study.springboot.all.study.springboot.all.vo.UserVo;

import java.util.List;

public interface UserService {
    UserVo queryById(Long id);

    UserVo handleException(boolean flag);

    UserDO insertUser(UserDO userDO);

    List<UserDO> queryAll();
}
