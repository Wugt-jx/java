package com.wgt.string;

import java.io.Serializable;

/**
 * 模拟java.lang.String类,
 *@author wgt
 */
public final class MyString implements Comparable<MyString>,Serializable{

    private final char[] values;    //类中维护的字符数组进行操作

    /**
     * 无参构造
     */
    public MyString() {
        values=new char[0];
    }

    /**
     *字符串常量构造
     * @param original
     */
    public MyString(String original) {
        this.values=original.toCharArray();
    }


    /**
     *从字符数组进行构造
     * @param values
     */
    public MyString(char[] values,int begin,int count) {
        this.values = new char[count];
        for (int i =begin;i<begin+count;i++){
            this.values[i]=values[i];
        }
    }

    public MyString(char[] values) {
        this(values,0,values.length);
    }

    /**
     * 拷贝深构造方法，复制对象
     * @param string
     */
    public MyString(MyString string){
        this(string.values);
    }


    /**
     * 获取长度
     * @return
     */
    public int length() {
        return this.values.length;
    }

    /**
     * 获取索引位置的char值
     * @param i
     * @return
     */
    public char charAt(int i) {
        if (i<0 || i>= this.values.length){
            throw new StringIndexOutOfBoundsException(i);
        }
        return this.values[i];
    }

    /**
     * 对字符串进行拼接
     * （由于java没有提供运算符重载功能，所以没办法提供 “+” 拼接字符串的功能）
     * @param str
     * @return
     */
    public MyString concat(MyString str) {
        if (str==null||str.length()==0){
            return this;
        }
        char[] buffer = new char[this.values.length + str.length()];
        int i;
        for (i=0;i<this.values.length;i++){
            buffer[i]=this.values[i];
        }
        for (int j=0;j<str.values.length;j++){
            buffer[i+j] = str.values[j];
        }
        return new MyString(buffer);
    }

    public MyString concat(String str){
        if (str==null || str.length()==0){
            return this;
        }
        char[] buffer = new char[this.values.length+ str.length()];
        int i;
        for (i=0;i<this.values.length;i++){
            buffer[i]=this.values[i];
        }
        for (int j=0;j<str.length();j++){
            buffer[i+j] = str.toCharArray()[j];
        }
        return new MyString(buffer);
    }

    /**
     * 获取指定区间的子字符串
     * @param begin
     * @param end
     * @return
     */
    public MyString subString(int begin, int end) {
        if (begin<0){begin=0;}
        if (end>this.values.length){end = this.values.length;}
        if (begin>end){throw new StringIndexOutOfBoundsException(end - begin);}
        if (begin==0&&end==this.values.length){return this;}
        char[] buffer = new char[end-begin];
        for (int i=0;i<buffer.length;i++){
            buffer[i] = this.values[i+begin];
        }
        return new MyString(buffer);
    }

    public MyString subString(int begin){
        return subString(begin,this.values.length);
    }


    /**
     * 实现比较器方法，方便比较大小
     * 如果返回0，标识两个字符串相等
     * @param o
     * @return
     */
    public int compareTo(MyString o) {
        for (int i=0;i<this.values.length && i<o.values.length;i++){
            if (this.values[i]!=o.values[i]){
                return this.values[i] - o.values[i];
            }
        }
        return this.values.length - o.values.length;
    }

    /**
     * 匹配字符模版在主字符串第一次出现的位置，如果不匹配则返回-1
     * @param pattern
     * @param begin
     * @return
     */
    public int indexOf(MyString pattern,int begin){
        if (pattern!=null && pattern.length()>0 && this.length()>=pattern.length()){
            int i=begin,j=0;
            while (i<this.length()){
                if (this.charAt(i)==pattern.charAt(j)){i++;j++;}
                else {
                    i=i-j+1;
                    j=0;
                }
                if (j==pattern.length()) {
                    return i - j;
                }
            }
        }
        return -1;
    }

    public int indexOf(MyString pattern){return this.indexOf(pattern,0);}

    public int indexOf(String pattern){return this.indexOf(new MyString(pattern));}

    /**
     * 返回将当前串中首次与pattern匹配的子串替换成replacement的字符串
     * @param pattern
     * @param replacement
     * @return
     */
    public MyString replaceFirst(MyString pattern,MyString replacement){
        int i = this.indexOf(pattern,0);
        if (i==-1){
            return this;
        }
        return this.subString(0,i).concat(replacement).concat(this.subString(i+pattern.length()));
    }

    /**
     * 返回将当前穿中所有与pattern匹配的子串全部替换成replacement的字符串
     * @param pattern
     * @param replacement
     * @return
     */
    public MyString replaceAll(MyString pattern,MyString replacement){
        MyString temp = new MyString(this);
        int i = this.indexOf(pattern,0);
        while (i!=-1){
            temp = temp.subString(0,i).concat(replacement).concat(temp.subString(i+pattern.length()));
            i = temp.indexOf(pattern,i+replacement.length());
        }
        return temp;
    }

    /**
     * 比较两个字符串是否内容相等
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this==obj){
            return true;
        }
        if (obj instanceof MyString){
            MyString str=(MyString)obj;
            if (this.values.length == str.values.length){
                for (int i=0;i<this.values.length;i++){
                    if (this.values[i]!=str.values[i]){return false;}
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return new String(this.values);
    }

}
