package com.xxx.async;

/**
 * 分析槽
 *
 * @author guodq
 * @create 2018-11-16 下午4:19
 */
@FunctionalInterface
public interface AnalysisSlot<T> {

    /**
     * 插入数据
     */
    void compute(T callLog);
}
