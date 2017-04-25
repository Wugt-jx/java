package com.wgt.stack;

import junit.framework.TestCase;

/**
 * Created by Administrator on 2017/4/25.
 */
public class SeqStackTest {
    public static void main(String[] args) {
        SStack<String>stack = new SeqStack<String>();
        stack.push("wgt");
        stack.push("wnl");
        stack.push("hjh");
        System.out.println(stack);
    }
}