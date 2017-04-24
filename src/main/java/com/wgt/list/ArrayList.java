package com.wgt.list;

/**
 * 顺序存储列表，与java.util.ArrayList原理相似（方法没有那么全面，模拟一些常用的方法）
 * @author wgt
 * @param <T>
 */
public class ArrayList<T> implements List<T> {

    private Object[] elements;  //list维护该数组进行操作
    private int len;            // 用len表示数组的长度

    /**
     * 初始集合长度
     * @param size
     */
    public ArrayList(int size) {
        if (size<0) {throw new NegativeArraySizeException("list size can't less than 0");}
        elements = new Object[size];
        len = 0;
    }

    /**
     * 不传参的情况下默认为64
     */
    public ArrayList() {
        this(64);
    }

    /**
     * 判断集合是否为空
     * @return
     */
    public boolean isEmpty() {
        return this.len==0;
    }

    /**
     * 查找值是否包含在该集合中
     * @param object
     * @return
     */
    public boolean contain(T object) {
        return false;
    }

    /**
     * 获取集合的长度
     * @return
     */
    public int getSize() {
        return this.len;
    }

    /**
     * 用指定元素替换列表中指定位置的元素
     * @param i 指定位置的索引
     * @param object  替换的元素值
     */
    public void set(int i, T object) {
        if (object==null){
            return;
        }
        if (i>=0&&i<this.len){
            this.elements[i]=object;
        }else{
            throw new IndexOutOfBoundsException(i+"");
        }
    }

    /**
     * 在集合最后添加元素
     * @param object
     */
    public void add(T object) {
        add(this.len,object);
    }

    /**
     * 在指定位置插入元素
     * @param i 插入的索引位置
     * @param object 插入的元素值
     */
    public void add(int i, T object) {
        if (object==null) return;
        if (this.len==elements.length)
        {
            Object[] temp=this.elements;
            this.elements=new Object[temp.length*2];
            for (int j=0;j<temp.length;j++){
                this.elements[j]=temp[i];
            }
        }
        if (i<0){i=0;}
        if (i<this.len){i=this.len;}
        for (int j = this.len-1;j>=i;j--){
            this.elements[j+1] = this.elements[j];
        }
        this.elements[i]=object;
        this.len++;
    }

    /**
     * 清空列表
     */
    public void removeAll() {
        this.len = 0;
    }

    /**
     * 获取指定索引的元素
     * @param i
     * @return
     */
    public T get(int i) {
        if (i>=0&&i<this.len){
            return (T)this.elements[i];
        }
        throw new IndexOutOfBoundsException(i+"");
    }

    /**
     *移除指定索引的元素，并返回该元素
     * @param i 移除的索引位置
     * @return  返回该索引位置的元素对象
     */
    public T remove(int i) {
        if (this.len==0||i<0||i>=this.len){
            return null;
        }
        T oldObject=(T)this.elements[i];
        for (int j=i;j<this.len-1;j++){
            this.elements[j] = this.elements[j+1];
        }
        this.elements[this.len-1]=null;
        this.len--;
        return oldObject;
    }

    /**
     *  从此列表中移除第一次出现的指定元素（如果存在）
     * @param object 要移除的元素
     * @return
     */
    public boolean remove(T object){
        if (this.indexOf(object)>=0){
            return (this.remove(indexOf(object))!=null);
        }
        return false;
    }

    /**
     * 返回此列表中第一次出现的指定元素的索引
     * @param key
     * @return  该元素的位置索引
     */
    public int indexOf(T key) {
        if (key!=null){
            for (int i=0;i<this.len;i++){
                if (this.elements[i].equals(key)){
                    return i;
                }
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        String str="(";
        if (this.len>0){
            str += this.elements[0].toString();
        }
        for (int i=1;i<this.len;i++){
            str += ", "+this.elements[i].toString();
        }
        return str+")";
    }
}
