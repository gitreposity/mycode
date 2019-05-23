package com.xxx.async;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 异步插入数据
 *
 * @author guodq
 * @create 2018-11-16 下午4:21
 */

public abstract class AsyncRecordAnalysisSlot<T> implements AnalysisSlot<T>{

    /**
     * 定义一个队列
     */
    private BlockingQueue<T> queue;

    /**
     *
     */
    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

    /**
     *  提供异步刷入服务
     * @param callLog
     */
    @Override
    public void compute(T callLog) {
        if (!queue.offer(callLog)){
            //如果放入队列失败，说明队列满了，则立马触发数据flush to db的任务
            flushAsync(callLog);
        }
    }

    public AsyncRecordAnalysisSlot(Integer flushOnSize, Integer flushOnTimeSecond) {
        queue = new LinkedBlockingDeque<>(flushOnSize);
        //启动5秒刷入DB的一个任务
        executorService.scheduleWithFixedDelay(() -> flushSync(null),
                flushOnTimeSecond,flushOnTimeSecond, TimeUnit.SECONDS);
    }

    public void flushAsync(final T callLog){
        executorService.submit(() -> flushSync(callLog));
    }

    /**
     * 默认写入策略为5秒或者达到积压了到达上限（50个）
     */
    public AsyncRecordAnalysisSlot() {
        this(50,5);
    }

    /**
     * 需要实现的刷入接口
     */
    protected abstract void batchFlush(List<T> ts);




    public void flushSync(T callLog){
        try {
            List<T> list = new ArrayList<>();
            if(callLog != null){
                list.add(callLog);
            }
            queue.drainTo(list);
            if(list.size() > 0){
                batchFlush(list);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
