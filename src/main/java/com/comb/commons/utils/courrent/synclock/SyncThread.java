package com.comb.commons.utils.courrent.synclock;

/**
 * Created by Administrator on 2016/9/9.
 */
public class SyncThread extends Thread {

    public static int i = 0 ;
    public static SyncThread ins = new SyncThread("");
    public SyncThread(String name){
        super.setName(name);
    }
    @Override
    public void run() {
            for(int j=0;j<10000;j++){
                super.getName();
                synchronized (SyncThread.class) {
                    i++;
                }
            }
    }
}
