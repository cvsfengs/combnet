package com.comb.commons.utils.mlog;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 在进行方法执行时,是否记录执行时间
 */
public class MTime {
    /**
     * 记录时间
     */
    private static ThreadLocal<Map<String,Long>> timeValue= new ThreadLocal<Map<String,Long>>();

    private static ThreadLocal<Long> timmerDiff = new ThreadLocal<Long>();
    /**
     * 最后一个时间点记录key
     */
    private static ThreadLocal<String> timeKey = new ThreadLocal<String>();

    /**
     * 记录时间开始
     */
//    public void timeStart(){//TODO 这里可以进行更详尽的写法,每次检测上一次是否有进行标记
//        String key = UUID.randomUUID().toString();
//        timeKey.set(key);
//        long startTime = System.currentTimeMillis();
//        Map<String,Long> map = new HashMap<String, Long>();
//        map.put(timeKey.get(),startTime);
//        timeValue.set(map);
//    }
    private void init(){
        if(timeValue.get()==null){
            timeValue = new ThreadLocal<Map<String, Long>>();
        }if(timmerDiff.get()==null){
            timmerDiff = new ThreadLocal<Long>();
        }if(timeKey.get()==null){
            timeKey = new ThreadLocal<String>();
        }
    }
    public void timeStart(){
        this.init();
        if(timeKey.get()!=null) {//此次行为为时间暂停行为
            Long tEnd = this.timeDiff();//算出距离上一次时间暂停diff时间
            Long diff = timmerDiff.get();
            if(diff==null){
                timmerDiff.set(tEnd);
            }else {
                timmerDiff.set(diff + tEnd);
            }
        }
        String key = UUID.randomUUID().toString();
        timeKey.set(key);
        long startTime = System.currentTimeMillis();
        Map<String,Long> map = new HashMap<String, Long>();
        map.put(timeKey.get(),startTime);
        timeValue.set(map);
    }

    /**
     * 结束时间不可为空
     * 起始时间为空 则认为 startTime=0
     */
    public Long timeDiff(){
        String key = timeKey.get();
        Map<String, Long> startTime = timeValue.get();
        Long stime = startTime.get(key);
        long endTime = System.currentTimeMillis();
        Long exeTime = endTime-stime ;
        //this.destoryThread(timeValue,timeKey);
        return exeTime;
    }
    /**
     * 记录时间结束
     */
    public Long timeEnd(){
        String key = timeKey.get();
        Map<String, Long> startTime = timeValue.get();
        Long stime = startTime.get(key);
        long endTime = System.currentTimeMillis();
        Long exeTime = endTime-stime+timmerDiff.get();
        this.destoryThread(timeValue,timeKey,timmerDiff);
        return exeTime;
    }
    /**
     * 销毁线程
     */
    public void destoryThread(ThreadLocal...threads){

        try {
            if(threads.length>0){
                ThreadLocal[] threadLocals = threads;
                for (ThreadLocal thread : threadLocals) {
                    thread.remove();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("销毁本地线程失败了?..." + e);
            destoryThread(threads);
        }
    }

}
