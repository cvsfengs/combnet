package com.comb.commons.utils.courrent.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yc.feng on 2016/9/11.
 * Reentrant 重入锁测试
 *
 */
public class ReentrantDoubleLock implements Runnable{

    private int lock ;

    public static int inc = 0;
    public static ReentrantLock lock1 = new ReentrantLock();

    public static ReentrantLock lock2 = new ReentrantLock();

//    @Override
//    public void run() {
//        for (int i = 0; i < 1000; i++) {
//            try {
//                lock1.lock();
//                lock1.lock();
//                System.out.println("the lock processs:"+inc++);
//            } finally {
//                lock1.unlock();
//                //注释掉一个,那么重入锁就不会被释放
//                lock1.unlock();
//            }
//        }
//    }

    public ReentrantDoubleLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        //lock 1
        try {
            if(lock==1){
                //设置成可中断的重入锁
                    lock1.lockInterruptibly();
                    System.out.println("the lock1 is locked:");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {}
                lock2.lockInterruptibly();
            }else {
                lock2.lockInterruptibly();
                System.out.println("the lock2 is locked:");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                lock1.lockInterruptibly();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock1.isHeldByCurrentThread()){
                lock1.unlock();
            }
            if(lock2.isHeldByCurrentThread()){
                lock2.unlock();
            }
        }
    }
}
