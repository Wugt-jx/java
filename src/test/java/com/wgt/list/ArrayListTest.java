package com.wgt.list;


/**
 * Created by Administrator on 2017/4/24.
 */
public class ArrayListTest  {

    public void test(int number,int start, int distance){
        List<String>list=new ArrayList<String>();
        for (int i=0;i<number;i++){
            list.add((char)('A'+i)+"");
        }
        System.out.println("约瑟夫环("+number+","+start+","+distance+"), ");
        System.out.println(list.toString());
        int i=start;
        while(list.getSize()>1){
            i=(i+distance-1) % list.getSize();
            System.out.println("删除"+list.remove(i).toString()+", ");
            System.out.println(list.toString());
        }
        System.out.println("被赦免者是："+list.get(0).toString());
    }

    public static void main(String[] args) {
        new ArrayListTest().test(5,0,2);
    }
}