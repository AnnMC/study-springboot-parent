package study.springboot.all.study.springboot.all.service.impl;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import study.springboot.all.study.springboot.all.annotation.RetryProcess;
import study.springboot.all.study.springboot.all.exception.BizException;
import study.springboot.all.study.springboot.all.service.RetryService;

import java.util.concurrent.atomic.AtomicInteger;

@Service("retryService")
public class RetryServiceImpl implements RetryService {
    private static Logger logger = LoggerFactory.getLogger(RetryServiceImpl.class);

    private ThreadLocal<AtomicInteger> threadLocal = new ThreadLocal<>();

    @RetryProcess(value = 3)
    @Override
    public void retry() {
        logger.info("业务执行");
        throw new BizException("业务异常了");
    }
}