package com.comb.commons.utils.courrent.threadlock;

/**
 * Created by Administrator on 2016/9/9.
 */
public class ObjectThread extends Thread{
    private static Object o = new Object();
    public ObjectThread(String tName){
        super.setName(tName);
    }

    @Override
    public void run() {
        synchronized (o){
            System.out.println("Thrad Name...."+super.getName());
            Thread.currentThread().suspend();
        }
    }
}
