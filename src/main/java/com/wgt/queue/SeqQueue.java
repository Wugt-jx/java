package com.wgt.queue;

/**
 * 顺序队列
 * @author wgt
 * @param <T>
 */
public class SeqQueue<T> implements QQueue<T> {

    private Object[] elements;
    private int front,rear;

    public SeqQueue(int length) {
        if (length<64){
            length=64;
        }
        this.elements=new Object[Math.abs(length)];
        this.front = this.rear = 0;
    }

    public SeqQueue() {
        this(64);
    }


    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.front==this.rear;
    }

    /**
     * 元素obj入队列
     * @param obj
     */
    public void enqueue(T obj) {
        if (obj == null){
            return;
        }
        if (this.front==(this.rear+1)%this.elements.length){
            Object[]temp=this.elements;
            this.elements = new Object[temp.length*2];
            int i = this.front,j=0;
            while (i!=this.rear){
                this.elements[j]=temp[i];
                i = (i+1)%temp.length;
                j++;
            }
            this.front = 0;
            this.rear =j;
        }
        this.elements[this.rear]=obj;
        this.rear = (this.rear+1)%this.elements.length;
    }

    /**
     * 队头元素出队列
     * @return
     */
    public T dequeue() {
        if (isEmpty()){return null;}
        T temp = (T)this.elements[this.front];
        this.front = (this.front+1)%this.elements.length;
        return temp;
    }


    @Override
    public String toString() {
        String str="(";
        if (!isEmpty()){
            str+=this.elements[this.front].toString();
            int i = (this.front+1)%this.elements.length;
            while (i!=this.rear){
                str +=","+this.elements[i].toString();
                i=(i+1)%this.elements.length;
            }
        }
        return str+")";
    }
}
