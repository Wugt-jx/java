package com.wgt.list;

/**
 * 继承链表类实现排序
 * @param <T>
 */
public class SortedLinkedList<T extends Comparable<T>> extends LinkedList<T> {
    public SortedLinkedList() {super();}
    public SortedLinkedList(T[] elements){
        super();
        for (int i=0;i<elements.length;i++){
            this.add(elements[i]);
        }
    }

    /**
     * 添加元素时候进行排序
     * @param object
     */
    @Override
    public void add(T object) {
        if (object==null){return;}
        if (this.head.prev!=head && this.head.prev.data.compareTo(object)<0){
            Node<T> q=new Node<T>(object,head.prev,head);
            head.prev.next=q;
            head.prev=q;
        }
        else {
            Node<T> p = this.head.next;
            while (p != head && p.data.compareTo(object) < 0) {
                p = p.next;
            }
            Node<T> q = new Node<T>(object, p.prev, p);
            p.prev.next = q;
            p.prev = q;
        }
    }

    /**
     * 不建议使用该方法，因为链表在插入时自动进行排序
     * @param i
     * @param object
     */
    @Deprecated
    @Override
    public void add(int i, T object) {
        this.add(object);
    }

    /**
     * 移除元素时也需要进行调位
     * @param object
     * @return
     */
    @Override
    public boolean remove(T object) {
        if (object==null){return false;}

        Node<T> p = this.head.next;
        while (p!=head && p.data.compareTo(object)<0){
            p=p.next;
        }
        if (p!=head && p.data.compareTo(object)==0){
            p.prev.next=p.next;
            p.next.prev=p.prev;
            return true;
        }
        return false;
    }

}
