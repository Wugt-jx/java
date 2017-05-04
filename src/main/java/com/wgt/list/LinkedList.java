package com.wgt.list;


/**
 * 双向链表，类似与java.util.LinkedList类
 * @author wgt
 * @param <T>
 */
public class LinkedList<T> implements List<T>{

    public Node<T> head;

    public LinkedList() {
        this.head=new Node<T>();
        this.head.prev=head;
        this.head.next=head;
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty() {
        return head.next==head;
    }

    /**
     * 查询是否包含元素
     * @param object
     * @return
     */
    public boolean contain(T object) {
        return this.indexOf(object)>=0;
    }

    /**
     * 获取集合长度
     * @return
     */
    public int getSize() {
        int i=0;
        Node<T> p = this.head.next;
        while (p.data!=null)  {
            i++;
            p=p.next;
        }
        return i;
    }

    /**
     * 设置指定索引位置的值
     * @param i
     * @param object
     */
    public void set(int i, T object) {
        if (object==null){return;}
        if (i>=0){
            Node<T>p=this.head.next;
            for (int j=0;p!=null&&j<i;j++){
                p=p.next;
            }
            if (p!=null){
                p.data=object;
            }
        }
        else{
            throw new IndexOutOfBoundsException(i+"");
        }
    }

    /**
     * 在链表的最后添加元素
     * @param object
     */
    public void add(T object) {
        if (object==null){return;}
        Node<T> q =new Node<T>(object,head.prev,head);
        head.prev.next = q;
        head.prev = q;
    }

    /**
     * 在指定位置插入新元素
     * @param i
     * @param object
     */
    public void add(int i, T object) {
        if (object==null){return;}
        Node<T> p =this.head;
        for (int j=0;p.next!=this.head&&j<i;j++){
            p=p.next;
        }
        Node<T> q = new Node<T>(object,p,p.next);
        p.next.prev=q;
        p.next=q;
    }

    /**
     * 清空链表
     */
    public void removeAll() {
        this.head.prev=head;
        this.head.next = head;
    }

    /**
     * 获取指定位置的元素
     * @param i
     * @return
     */
    public T get(int i) {
        if (i>=0){
            Node<T> p = this.head.next;
            for (int j=0;p!=null&&j<i;j++){
                p=p.next;
            }
            if (p!=null){
                return p.data;
            }
        }
        return null;
    }

    /**
     * 移除指定位置元素
     * @param i
     * @return
     */
    public T remove(int i) {
        if (i>this.getSize()){throw new IndexOutOfBoundsException(i+"");}
        if (i>=0){
            Node<T> p =this.head.next;
            for (int j=0;p!=head&&j<i;j++){
                p=p.next;
            }
            if (p!=head){
                T old=p.data;
                p.prev.next=p.next;
                p.next.prev=p.prev;
                return old;
            }
        }
        return null;
    }

    /**
     * 移除指定元素（如果存在的话）
     * @param object
     * @return
     */
    public boolean remove(T object) {
        if (object==null){return false;}
        if (this.getSize()>0&&this.remove(this.indexOf(object))==null){
            return false;
        }

        return true;
    }

    /**
     * 查询元素第一次出现的索引位置
     * @param key
     * @return
     */
    public int indexOf(T key) {
        int index = 0;
        if (key == null) {
            throw new NullPointerException("key is null");
        } else {
            for (Node<T> p = head; p != null; p = p.next) {
                if (key.equals(p.data))
                {return index;}
                index++;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        String str="(";
        Node<T> p=this.head.next;
        while (p.data!=null){
            str += p.data.toString();
            if (p.next.data!=null){
                str += ", ";
            }
            p=p.next;
        }
        return str+=")";
    }




    /**
     * 链表结合维护的节点类
     * @param <T>
     */
    public static class Node<T>{
        T data;
        Node<T>prev,next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node() {
        }
    }
}
