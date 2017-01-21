package com.comb.commons.utils.courrent.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yc.feng on 2016/9/10.
 */
public class ReentrantLockClass implements Runnable{
    public static Integer atomic = 0;
    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            try {
               lock.lock();
                //atomic=i;
                atomic++;
            } finally {
                lock.unlock();
            }
        }
    }
}
