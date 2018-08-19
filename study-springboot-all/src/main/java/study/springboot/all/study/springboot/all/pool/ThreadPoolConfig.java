package study.springboot.all.study.springboot.all.pool;

import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池使用
 */
public class ThreadPoolConfig {
    @Bean(value = "adExecutorService")
    public ExecutorService buildExecutorService() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        return executorService;
    }
}