package com.wgt.string;

import java.io.Serializable;

/**
 * 模拟StringBuffered类
 * @author wgt
 */
public class MyStringBuffer implements Serializable {

    private char[] values;
    private int len;

    public MyStringBuffer(int size){
        this.values = new char[size<16?16:size];
        this.len=0;
    }

    /**
     * 无参构造
     */
    public MyStringBuffer(){
        this(16);
    }

    public MyStringBuffer(String string){
        this(string.length());
        this.append(string);
    }

    /**
     * 获取长度
     * @return
     */
    public int length(){
        return this.len;
    }

    /**
     * 获取指定索引位置的char值
     * @param i
     * @return
     */
    public synchronized char charAt(int i){
        if (i<0|| i>=this.len){
            throw new StringIndexOutOfBoundsException(i);
        }
        return this.values[i];
    }

    /**
     * 设置指定索引位置的char值
     * @param i
     * @param ch
     */
    public void setCharAt(int i,char ch){
        if (i<0||i>=this.len){
            throw new StringIndexOutOfBoundsException(i);
        }
        this.values[i]=ch;
    }

    /**
     * 在指定位置插入字符串，加synchronized锁住方法保证线程安全
     * @param i
     * @param str
     * @return
     */
    public synchronized MyStringBuffer insert(int i,MyStringBuffer str){
        if (i<0){i=0;}
        if (i>this.len) {i=this.len;}
        if (str == null){return this;}
        char[] temp=this.values;
        if (this.values.length - this.len <str.len){
            this.values = new char[this.values.length+str.len*2];
            for (int j=0;j<i;j++){this.values[j]=temp[j];}
        }
        for (int j=i;j<this.len;j++){
            this.values[str.len+j] = temp[j];
        }
        for (int j=0; j<str.len;j++){
            this.values[i+j] = str.values[j];
        }
        this.len += str.len;
        return this;
    }

    /**
     * 在指定位置插入字符串，加synchronized锁住方法保证线程安全
     * @param i
     * @param str
     * @return
     */
    public synchronized MyStringBuffer insert(int i,String str){
        if (i<0){i=0;}
        if (i<this.len){i=this.len;}
        if (str == null){return this;}
        char[] temp=this.values;
        if (this.values.length - this.len < str.length()){
            this.values = new char[this.values.length + str.length()*2];
            for (int j=0;j<i;j++){this.values[j] = temp[j];}
        }
        for (int j=i;j<this.len;j++){
            this.values[str.length()+j] = temp[j];
        }
        for (int j=0;j<str.length();j++){
            this.values[i+j] = str.toCharArray()[j];
        }
        this.len += str.length();
        return this;
    }

    /**
     * 删除指定作引区间的子字符串
     * @param begin
     * @param end
     * @return
     */
    public synchronized MyStringBuffer delete(int begin,int end){
        if (begin<0){
            begin=0;
        }
        if (end>this.len){end = this.len;}
        if (begin > end){
            throw new StringIndexOutOfBoundsException(end-begin);
        }
        for (int i=0;i<this.len-end;i++){
            this.values[begin+i]=this.values[end+i];
        }
        this.len -=end-begin;
        return this;
    }

    /**
     * 在i处插入变量值转换成的串
     * @param i
     * @param b
     * @return
     */
    public synchronized MyStringBuffer insert(int i, boolean b){
        return this.insert(i,b?"true":"false");
    }

    /**
     * 添加指定串
     * @param str
     * @return
     */
    public synchronized MyStringBuffer append(String str){
        return this.insert(this.len,(str==null)?"null":str);
    }


    public synchronized String toString(){
        return new String(this.values,0,this.len);
    }
}
