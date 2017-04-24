package com.wgt.list;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by wgt on 2017/4/24.
 */
public class LinkedListTest extends TestCase {

    @Test
    public void test(){
        LinkedList<String> linkedList=new LinkedList<String>();
        System.out.println(linkedList.isEmpty());
        linkedList.add("ddas");
        System.out.println(linkedList);
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

    }
}