package com.comb.commons.utils.courrent.synclock;

/**
 *
 */
public class SyncDemo {

    public static void main(String[] args) throws InterruptedException {
        SyncThread sy1 = new SyncThread("sy1");
        SyncThread sy2 = new SyncThread("sy2");

        sy1.start();
        sy2.start();

        System.out.println(" 线程正在全部高速启动");

        sy1.join();
        sy2.join();

        System.out.println("线程全部启动完毕:"+sy1.i+"----"+sy2.i);
    }

}
