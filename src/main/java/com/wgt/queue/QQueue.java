package com.wgt.queue;

/**
 * 队列（queue）是一种特殊的线性表，其插入和删除操作分别在线性表的两端进行。
 * 想队列中插入元素的过程成为入队（enqueue），删除元素的过程成为出队(dequeue).
 * 允许入队的一端称为队尾（rear），允许出队的一端成为对头(front)
 *
 * 队列接口
 * @author wgt
 * @param <T>
 */
public interface QQueue<T> {
    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 元素obj入栈
     * @param obj
     */
    void enqueue(T obj);

    /**
     * 出队，返回对头元素
     * @return
     */
    T dequeue();
}
