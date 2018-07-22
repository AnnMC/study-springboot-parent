package study.springboot.all.study.springboot.all.thread;

import java.util.concurrent.*;

/**
 * 自定义线程池
 */
public class SdThreadPoolExecutor extends ThreadPoolExecutor {
    // 记录运行中的任务
    private LinkedBlockingDeque<Runnable> workBlockingQueue = new LinkedBlockingDeque<>();

    public SdThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        workBlockingQueue.add(r); // 记录运行中的任务
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        workBlockingQueue.remove(r); // 移除运行中的任务
    }

    public LinkedBlockingDeque<Runnable> getWorkBlockingQueue() {
        return workBlockingQueue;
    }
}