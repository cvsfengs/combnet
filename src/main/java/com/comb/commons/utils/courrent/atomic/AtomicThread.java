package com.comb.commons.utils.courrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Administrator on 2016/9/10.
 */
public class AtomicThread  extends Thread{

    public static AtomicInteger i = new AtomicInteger();

    @Override
    public void run() {
        for (int j=0;j<10000;j++){
            //i.set(j);
            i.incrementAndGet();
        }
    }

}
