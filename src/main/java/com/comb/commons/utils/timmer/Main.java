package com.comb.commons.utils.timmer;

import com.comb.commons.utils.timmer.pojo.TimePojo;
import com.comb.commons.utils.timmer.waper.LogTimerImpl;

/**
 * Created by ycfeng on 2016/8/10.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        TimePojo pojo = new TimePojo();
        LogTimerImpl logTimer = new LogTimerImpl();
        logTimer.startMark(pojo);

        Thread.sleep(10000);

        System.out.println("hheh");

        long timer = logTimer.getTimer(pojo);

        System.out.println(timer);

    }

}
