package com.wgt.string;

import junit.framework.TestCase;

/**
 * Created by Administrator on 2017/4/25.
 */
public class MyStringTest extends TestCase {
    public static void main(String[] args) {
        MyString str=new MyString("wgt");
        MyString str2=new MyString("wgt");
        System.out.println(str);
        System.out.println(str.compareTo(str2));
        System.out.println(str.equals(str2));
        System.out.println(str.length());
        System.out.println(str.charAt(2));
        System.out.println(str.concat("110"));
        System.out.println(str.indexOf("gt"));
        System.out.println(str.subString(1,3));
        System.out.println(str.replaceFirst(new MyString("gt"),new MyString("ww")));
    }
}