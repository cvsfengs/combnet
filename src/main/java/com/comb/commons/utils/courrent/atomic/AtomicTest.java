package com.comb.commons.utils.courrent.atomic;

/**
 * Created by Administrator on 2016/9/10.
 */
public class AtomicTest {

    public static void main(String[] args) throws InterruptedException {
        AtomicThread target = new AtomicThread();
        Thread [] tarr = new Thread[10];
        for(int i = 0 ;i<10;i++){
            tarr[i]=new Thread(target);
        }
        for (int i = 0 ;i<10;i++){
            tarr[i].start();
        }
        for (int i = 0 ;i<10;i++){
            tarr[i].join();
        }
        System.out.println(target.i);

       // AtomicReference\
        
    }











}
