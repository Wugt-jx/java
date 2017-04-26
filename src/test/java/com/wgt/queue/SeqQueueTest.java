package com.wgt.queue;

import com.wgt.list.ArrayList;

/**
 * Created by Administrator on 2017/4/26.
 */
public class SeqQueueTest {

    public SeqQueueTest(int n) {
        ArrayList<Integer> ring = new ArrayList<Integer>(n);
        ring.add(new Integer(1));
        SeqQueue<Integer> que = new SeqQueue<Integer>(n);
        for (int i=2;i<=n;i++){
            que.enqueue(new Integer(i));
        }
        int i=0;
        while (!que.isEmpty()){
            int k = que.dequeue().intValue();
            if (isPrime(ring.get(i)+k)){
                i++;
                ring.add(new Integer(k));
            }else{
                que.enqueue(new Integer(k));
            }
        }
        System.out.println("素数环："+ring.toString());
    }


    public boolean isPrime(int k){
        if( k ==2){
            return true;
        }
        if (k<2 ||k>2 && k%2==0){
            return false;
        }
        int j =(int)Math.sqrt(k);
        if (j%2 ==0){
            j--;
        }
        while(j>2 && k%j!=0){
            j-=2;
        }
        return j<2;
    }


    public static void main(String[] args) {
        new SeqQueueTest(10);
    }
}