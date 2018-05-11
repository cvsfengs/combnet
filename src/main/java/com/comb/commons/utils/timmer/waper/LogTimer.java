package com.comb.commons.utils.timmer.waper;

import com.comb.commons.utils.timmer.pojo.TimePojo;

/**
 */
public interface LogTimer {

    //ThreadLocal<LogTimer> LOG_TIMER_THREAD_LOCAL = new ThreadLocal<LogTimer>();

    /**
     * 开始
     */
    public boolean startMark(TimePojo timePojo,Object...msg);

    /**
     * 暂停
     */
    public boolean stop(TimePojo timePojo);

    /**
     * 获取时间
     */
    public long getTimer(TimePojo timePojo);

    /**
     * 销毁
     */
    public boolean destory(TimePojo timePojo);



}
