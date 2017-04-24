package com.wgt.list;

import junit.framework.TestCase;

/**
 * Created by Administrator on 2017/4/24.
 */
public class SinglyLinkedListTest{


    public static void main(String[] args) {
        SinglyLinkedList<String>linkedList=new SinglyLinkedList<String>();
        System.out.println(linkedList);
        System.out.println(linkedList.isEmpty());
        linkedList.add("ddas");
        linkedList.add("dbasjhvbfh");
        linkedList.add("dvbasjh");
        linkedList.add("dasbd");
        System.out.println(linkedList);
        System.out.println(linkedList.isEmpty());
        System.out.println("///////////////////");
        System.out.println(linkedList.contain("ddas"));
        System.out.println(linkedList.getSize());
        linkedList.set(1,"wgt");
        System.out.println(linkedList);
        System.out.println("////////////////////");
        linkedList.add("wnl");
        System.out.println(linkedList);
        System.out.println(linkedList.get(3));
        System.out.println(linkedList.remove(4));
        System.out.println(linkedList);
        System.out.println(linkedList.remove("wgt"));
        System.out.println(linkedList);
        System.out.println("//////////////////////////");
        System.out.println(linkedList.indexOf("dasbd"));
    }
}