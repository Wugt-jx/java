package com.wgt.queue;

import com.wgt.list.SortedLinkedList;

/**
 * 优先队列：
 * 有些应用系统中的排队等待问题，一般按照“先来先服务”，原则不能满足要求，
 * 还需要按照任务的轻重缓急程度作为排队的依据，就像系统中的进程的优先级，优先级高的进程先执行
 *如果一个队列的每个元素都有一个优先级，每次出队的是具有最高优先级的元素，
 *@author wgt
 */
public class PriorityQueue<T extends Comparable<T>>implements QQueue<T> {

    private SortedLinkedList<T> list;

    public PriorityQueue() {
        this.list = new SortedLinkedList<T>();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void enqueue(T obj) {
        this.list.add(obj);
    }

    public T dequeue() {
        return this.list.remove(0);
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
