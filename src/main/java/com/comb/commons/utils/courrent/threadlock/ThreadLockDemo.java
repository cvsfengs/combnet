package com.comb.commons.utils.courrent.threadlock;

/**
 * Created by yc.feng on 2016/9/9.
 * java 并发测试类
 * 线程锁等待
 * 线程1 启动,sleep 为了保证 线程1 真的进入suspend
 * 线程2 启动，由于线程1 占用锁 线程2 进行等待
 * 线程1 唤起 释放 但是这时候可能线程 2 还没来得及进入run 这时候就进入resume 这样就会造成锁等待
 * jsp 查看所有java 进程
 * jstack pid 查看所有启动线程
 */
public class ThreadLockDemo {
    private static ObjectThread ot1 = new ObjectThread("th1");
    private static ObjectThread ot2 = new ObjectThread("th2");

    public static void main(String[] args) throws InterruptedException {
        ot1.start();
        Thread.sleep(100);
        ot2.start();
        ot1.resume();
        ot2.resume();
        ot1.join();
        ot2.join();
    }






}
