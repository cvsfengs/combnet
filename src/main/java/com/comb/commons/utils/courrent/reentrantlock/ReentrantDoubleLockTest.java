package com.comb.commons.utils.courrent.reentrantlock;

/**
 * Created by Administrator on 2016/9/11.
 */
public class ReentrantDoubleLockTest {
    //重入锁测试
/*
    public static void main(String[] args) throws InterruptedException {
        ReentrantDoubleLock doubleLock1 = new ReentrantDoubleLock(1);
        ReentrantDoubleLock doubleLock2 = new ReentrantDoubleLock(1);
        Thread th1 = new Thread(doubleLock1);
        Thread th2 = new Thread(doubleLock1);
        th1.start();
        th2.start();
        th1.join();
        th2.join();
        System.out.println("the main was running down:success"+doubleLock1.inc);
    }
*/
    public static void main(String[] args) throws InterruptedException {

        ReentrantDoubleLock doubleLock1 = new ReentrantDoubleLock(1);
        ReentrantDoubleLock doubleLock2 = new ReentrantDoubleLock(2);
        Thread th1 = new Thread(doubleLock1);
        Thread th2 = new Thread(doubleLock2);
        th1.start();
        Thread.sleep(50);
        th2.start();
//        th1.join();
//        th2.join();
//        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
//        threadMXBean.findDeadlockedThreads();
        System.out.println("the main was running down:success"+doubleLock1.inc);
    }


}
