package com.wgt.stack;

/**
 * 顺序存储结构的栈（顺序栈）
 * 栈的出入顺序是，先进后出，后进先出
 * @author wgt
 * @param <T>
 */
public class SeqStack<T> implements SStack<T> {

    private Object elements[];
    private int top;

    /**
     * 构造指定容量的空栈
     * @param size
     */
    public SeqStack(int size) {
        this.elements = new Object[Math.abs(size)];
        this.top = -1;
    }

    /**
     * 构造默认容量的空栈
     */
    public SeqStack() {
        this(64);
    }

    /**
     * 判断是否空栈
     * @return
     */
    public boolean isEmpty() {
        return this.top==-1;
    }

    /**
     * 元素obj入栈，空对象不能入栈
     * @param obj
     */
    public void push(T obj) {
        if (obj == null){return;}
        if (this.top == elements.length-1){
            Object[] temp = this.elements;
            this.elements = new Object[temp.length*2];
            for (int i=0;i<temp.length;i++){
                this.elements[i] = temp[i];
            }
        }
        this.top++;
        this.elements[this.top]=obj;
    }

    /**
     * 出栈，返回栈顶元素，若栈为空返回null
     * @return
     */
    public T pop() {
        return this.top==-1 ? null : (T)this.elements[this.top--];
    }

    /**
     * 取栈顶元素，未出栈，若栈为空则返回null
     * @return
     */
    public T get() {
        return this.top==-1 ? null : (T)this.elements[this.top];
    }


    @Override
    public String toString() {
        String str="(";
        if (this.top>=0){
            str += this.elements[0].toString();
        }
        for (int i=1;i<this.top+1;i++){
            str += ", "+this.elements[i].toString();
        }
        return str+")";
    }
}
