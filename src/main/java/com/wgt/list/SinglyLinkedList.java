package com.wgt.list;


/**
 * 单向的链表，只能调取下一个元素的地址，没有保存上一个元素
 * @author wgt
 */
public class SinglyLinkedList<T> implements List<T>{

    protected Node<T> head; //链表维护的头结点

    /**
     * 无参构造
     */
    public SinglyLinkedList() {
        this.head=new Node<T>();
    }

    public SinglyLinkedList(T[] elements){
        this();
        Node<T> rear=this.head;
        for (int i=0;i<elements.length;i++){
            rear.next=new Node<T>(elements[i],null);
            rear=rear.next;
        }
    }

    /**
     * 判空
     * @return
     */
    public boolean isEmpty() {
        return this.head.next==null;
    }

    /**
     * 查找集合是否包含元素
     * @param object
     * @return
     */
    public boolean contain(T object) {
        return this.indexOf(object)>=0;
    }

    /**
     * 获取链表的长度
     * @return
     */
    public int getSize() {
        int i=0;
        Node<T> p = this.head.next;
        while (p!=null){
            i++;
            p=p.next;
        }
        return i;
    }

    /**
     * 用指定元素替换列表中指定位置的元素
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
     *  向列表的尾部添加指定的元素
     * @param object
     */
    public void add(T object) {
        add(Integer.MAX_VALUE,object);
    }

    /**
     * 在列表的指定位置插入指定元素
     * @param i
     * @param object
     */
    public void add(int i, T object) {
        if (object==null){return;}
        Node<T> p =this.head;
        for (int j=0;p.next!=null&& j<i;j++){
            p=p.next;
        }
        p.next=new Node<T>(object,p.next);
    }

    /**
     * 清空集合
     */
    public void removeAll() {
        this.head.next=null;
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
     * 移除指定位置的元素
     * @param i
     * @return
     */
    public T remove(int i) {
        if (this.isEmpty()||i<0){return null;}
        Node<T> p =this.head;
        for (int j=0;p.next!=null&&j<i;j++){
            p=p.next;
        }
        if (p.next!=null){
            T old=p.next.data;
            p.next=p.next.next;
            return old;
        }
        return null;
    }

    /**
     * 移除指定元素（如果存在的话）
     * @param object
     * @return
     */
    public boolean remove(T object) {
        if (this.head.next==null||object==null){
            return false;
        }
        Node<T> front = this.head, p=front.next;
        while(p!=null&&!p.data.equals(object)){
            front=p;
            p=p.next;
        }
        if (p!=null){
            front.next = p.next;
            return true;
        }
        return false;
    }

    /**
     * 返回此列表中第一次出现的指定元素的索引
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
        Node<T>p=this.head.next;
        while (p!=null){
            str += p.data.toString();
            if (p.next!=null){
                str += ", ";
            }
            p=p.next;
        }
        return str+=")";
    }

    /**
     * 还有hashCode和equals等方法不再续写
     */


    /**
     * 链表维护的节点类，记录了下一个元素
     * @param <T>
     */
    private static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
            this(null,null);
        }
    }

}
