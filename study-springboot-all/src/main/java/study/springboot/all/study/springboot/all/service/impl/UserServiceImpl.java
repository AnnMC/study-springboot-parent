package study.springboot.all.study.springboot.all.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.springboot.all.study.springboot.all.domain.AccountDO;
import study.springboot.all.study.springboot.all.domain.UserDO;
import study.springboot.all.study.springboot.all.exception.BizException;
import study.springboot.all.study.springboot.all.reposity.AccountReposity;
import study.springboot.all.study.springboot.all.reposity.UserReposity;
import study.springboot.all.study.springboot.all.service.AccountService;
import study.springboot.all.study.springboot.all.service.UserService;
import study.springboot.all.study.springboot.all.vo.UserVo;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserReposity userReposity;

    @Override
    public UserVo queryById(Long id) {
        UserDO userDO = userReposity.getOne(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(userDO, userVo);
        return userVo;
    }

    @Override
    public UserVo handleException(boolean flag) {
        if (flag) {
            throw new BizException("异常测试");
        }
        return new UserVo();
    }

    @Override
    public UserDO insertUser(UserDO userDO) {
        return userReposity.save(userDO);
    }

    @Override
    public List<UserDO> queryAll() {
        return userReposity.findAll();
    }
}
