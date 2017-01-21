package com.comb.commons.utils.courrent.reentrantlock;

/**
 * Created by yc.feng on 2016/9/10.
 * ReentrantLock 测试用例
 * 测试比较浅显,但是感觉这个lock 真是很有逼格
 * 顺便测试了一下 多线程lock进行自增效率与单线自增比较
 * ++++++++++++++++++++++++++++++++++++++++++++++++
 * the ReentrantLockClass was down...100000the time:105
 * the no thread:10000the time0
 * ++++++++++++++++++++++++++++++++++++++++++++++++
 * the ReentrantLockClass was down...100000the time:73
 * the no thread:10000the time0
 *+++++++++++++++++++++++++++++++++++++++++++++++++
 * the ReentrantLockClass was down...100000the time:75
 * the no thread:10000the time1
 *+++++++++++++++++++++++++++++++++++++++++++++++++
 * the ReentrantLockClass was down...100000the time:74
 * the no thread:10000the time0
 *==================================================
 * 第一次时间之所以太高,我的猜测是因为第一次编译的事情
 * 随后趋于稳定的状态
 */
public class ReentrantLockTest {


    public static void main(String[] args) throws InterruptedException {
        ReentrantLockClass target = new ReentrantLockClass();
        Thread [] tarr = new Thread[10];
        long currentStart = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            tarr[i]=new Thread(target);
        }
        for (int i = 0; i < 10; i++) {
            tarr[i].start();
        }
        for (int i = 0; i < 10; i++) {
            tarr[i].join();
        }
        long currentEnd = System.currentTimeMillis();
        System.out.println("the ReentrantLockClass was down..."+target.atomic+"the time:"+(currentEnd-currentStart));

        long currentStarted = System.currentTimeMillis();
        int j =0;
        for (int i = 0; i <10000; i++) {
            j++;
        }
        long currentEnds = System.currentTimeMillis();
        System.out.println("the no thread:"+j+"the time"+(currentEnds-currentStarted));

    }




}
