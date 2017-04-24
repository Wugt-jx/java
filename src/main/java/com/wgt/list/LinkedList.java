package com.wgt.list;

/**
 * 双向链表，类似与java.util.LinkedList类
 * @author wgt
 * @param <T>
 */
public class LinkedList<T> implements List<T>{





    /**
     * 判空
     * @return
     */
    public boolean isEmpty() {
        return false;
    }

    public boolean contain(T object) {
        return false;
    }

    public int getSize() {
        return 0;
    }

    public void set(int i, T object) {

    }

    public void add(T object) {

    }

    public void add(int i, T object) {

    }

    public void removeAll() {

    }

    public T get(int i) {
        return null;
    }

    public T remove(int i) {
        return null;
    }

    public boolean remove(T object) {
        return false;
    }

    public int indexOf(T key) {
        return 0;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 链表结合维护的节点类
     * @param <T>
     */
    private static class Node<T>{
        T data;
        Node<T>prev,next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node() {
            this(null,null,null);
        }
    }
}
