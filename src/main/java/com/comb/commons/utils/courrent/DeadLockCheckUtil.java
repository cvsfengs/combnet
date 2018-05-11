package com.comb.commons.utils.courrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 */
public class DeadLockCheckUtil implements Runnable{
    private DeadLockCheckUtil(){};
    //获取vm中所有 线程bean
    private static final ThreadMXBean mxbean = ManagementFactory.getThreadMXBean();
    @Override
    public void run() {
        while (true){
            //获取死锁线程id
            long[] deadlockedIds = mxbean.findDeadlockedThreads();
            if(deadlockedIds !=null){
                ThreadInfo[] threadInfo = mxbean.getThreadInfo(deadlockedIds);
                for (Thread info : Thread.getAllStackTraces().keySet()) {
                    for (int i = 0; i < threadInfo.length; i++) {
                        if(info.getId()==threadInfo[i].getThreadId()){
                            info.interrupt();
                        }
                    }
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //检测死锁
    public static void checker(){
        DeadLockCheckUtil death = new DeadLockCheckUtil();
        Thread daemon = new Thread(death);
        daemon.setDaemon(true);
        daemon.start();
    }
}
