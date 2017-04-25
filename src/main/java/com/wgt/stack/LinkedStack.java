package com.wgt.stack;

/**
 * 链式栈表
 * @author wgt
 * @param <T>
 */
public class LinkedStack<T> implements SStack<T> {

    private Node<T> top;    //栈顶节点，单链表节点

    /**
     * 构造空栈
     */
    public LinkedStack() {
        this.top = null;
    }

    /**
     * 判断是否空栈
     * @return
     */
    public boolean isEmpty() {
        return this.top==null;
    }

    /**
     * 入栈
     * @param obj
     */
    public void push(T obj) {
        if (obj!=null){
            this.top = new Node<T>(obj,this.top);
        }
    }

    /**
     * 出栈
     * @return
     */
    public T pop() {
        if (this.top == null){return null;}
        T temp = this.top.data;
        this.top = this.top.next;
        return temp;
    }

    /**
     * 取栈顶元素，不取出，若栈空返回null
     * @return
     */
    public T get() {
        return this.top == null ? null:this.top.data;
    }


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
