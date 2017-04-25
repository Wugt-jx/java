package com.wgt.queue;

/**
 * 链表队列
 * @param <T>
 */
public class LinkedQueue<T> implements QQueue<T> {

    private Node<T> front,rear;

    public LinkedQueue() {
        this.front=this.rear=null;
    }

    /**
     * 判断队列是否为空，若为空返回true
     * @return
     */
    public boolean isEmpty() {
        return this.front==null && this.rear==null;
    }

    /**
     * 元素obj加入队列
     * @param obj
     */
    public void enqueue(T obj) {
        if (obj==null){
            return;
        }
        Node<T> q = new Node<T>(obj,null);
        if (this.front==null){
            this.front=q;
        }else {
            this.rear.next=q;
        }
        this.rear=q;
    }

    /**
     * 对头元素出队列，返回对头元素，若队列空返回null
     * @return
     */
    public T dequeue() {
        if (isEmpty()){
            return null;
        }
        T temp = this.front.data;
        this.front=this.front.next;
        if (this.front==null){
            this.rear = null;
        }
        return temp;
    }


    /**
     * 单向链表的节点
     * @param <T>
     */
    private static class Node<T>{

        private T data;
        private Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            this(null,null);
        }
    }
}
