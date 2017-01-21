package com.comb.commons.utils.mlog;
import org.apache.commons.lang.BooleanUtils;

/**
 * Created by ycfeng on 2016/9/6.
 * mapi log 工具类:负责封装信息
 */
public class MLogger extends MTime{
    /**
     * 日志行为:log4j hbase all
     */
    private static Boolean logTime = BooleanUtils.toBoolean(CurrentEvnProperties.getProperties("logTime"));

    private static Boolean switchDetailMsg = BooleanUtils.toBoolean(CurrentEvnProperties.getProperties("switchDetailMsg"));

    /**
     * 设置成员变量
     */
    private Class clazz;

    /**
     * 开启日志
     */
    public void writeLogStart(Class clazz,Object...o){
        try
        {
            if(logTime){
                super.timeStart();
            }
            //获取上一层堆栈调用
            StackTraceElement upperStackTrace = Thread.currentThread().getStackTrace()[2];
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(MAbsUtil.getCurrentIp());
            for (Object msg : o) {
                stringBuffer.append(msg);
            }
            stringBuffer.append(upperStackTrace);
            //写log
            this.setClazz(clazz);
            MLogUtil.wmLog(clazz, stringBuffer.toString());
        } catch (Exception e)
        {
            MLogUtil.wmLog(null,"日志工具类方法初始化失败");
        }

    }
    public void writeLogStart(Object...o){
        try
        {
            if(logTime){
                super.timeStart();
            }
            //获取上一层堆栈调用
            StackTraceElement upperStackTrace = Thread.currentThread().getStackTrace()[2];
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(MAbsUtil.getCurrentIp());
            for (Object msg : o) {
                stringBuffer.append(msg+"\n");
            }
            stringBuffer.append(upperStackTrace+"\n");
            //写log
            this.setClazz(clazz);
            MLogUtil.wmLog(clazz, stringBuffer.toString());
        } catch (Exception e)
        {
            MLogUtil.wmLog(null,"日志工具类方法初始化失败");
        }

    }

    /**
     * 关闭日志
     */
    public void writeLogStop(Object...o){
        // 获取上一层堆栈调用
        StackTraceElement upperStackTrace = Thread.currentThread().getStackTrace()[2];
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MAbsUtil.getCurrentIp());
        for (Object msg : o) {
            stringBuffer.append(msg+"\n");
        }
        Long timeEnd = null;
        if(logTime){
            timeEnd = super.timeEnd();
        }
        if(timeEnd!=null){
            stringBuffer.append(" This Logger running..:"+timeEnd+"ms\n");
        }else {
            stringBuffer.append(" LoggerTimerNotOpen.\n");
        }
        MLogUtil.wmLog(this.getClazz(), stringBuffer.toString());
    }

    public MLogger(Class clazz) {
        this.clazz = clazz;
    }
    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }
}
