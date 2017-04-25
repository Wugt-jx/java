package com.wgt.list;

import junit.framework.TestCase;

/**
 * Created by wgt on 2017/4/24.
 */
public class SortedLinkedListTest extends TestCase {


    public void test(){
        SortedLinkedList<Integer> linkedList=new SortedLinkedList<Integer>();
        linkedList.add(23);
        linkedList.add(22);
        linkedList.add(78);
        linkedList.add(98);
        linkedList.add(11);
        linkedList.add(1,23);
        System.out.println(linkedList);
        linkedList.remove(new Integer(23));
        System.out.println(linkedList);
    }

}