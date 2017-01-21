package com.comb.commons.utils.mlog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by ycfeng on 2016/9/6.
 */
public class MLogUtil {

    private static String logType = CurrentEvnProperties.getProperties("logType");
    //log4j
    private static Logger LOGGER = null ;
    //hbase
    private static  Object hbase = null ;
    //初始化成员变量
    private static void initLogger(Class clazz){
        if(clazz==null){
            clazz = MLogUtil.class;
        }
        LOGGER = LoggerFactory.getLogger(clazz);
    }
    /**
     * 写log
     */
    public static void wmLog(Class clazz,String msg){
        if(logType.equals(MAPILogCst.LOG4J)){
            initLogger(clazz);
            LOGGER.error(msg);
        }else if(logType.equals(MAPILogCst.HBASE)){
            hbase.toString();
        }else {
            LOGGER.error(msg);
            hbase.toString();
        }
    }

}
