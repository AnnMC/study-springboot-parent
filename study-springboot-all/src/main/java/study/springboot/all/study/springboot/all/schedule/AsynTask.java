package study.springboot.all.study.springboot.all.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * 异步任务加线程池
 */
//@Component
public class AsynTask {
    private static Logger logger = LoggerFactory.getLogger(AsynTask.class);

    public static Random random = new Random();

    @Async("taskExecutor")
    @Scheduled(cron = "0 */1 * * * ?")
    public void asynTask() throws InterruptedException {
        logger.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(1000));
        long end = System.currentTimeMillis();
        logger.info("完成任务一，耗时：" + (end - start) + "毫秒");
    }
}
