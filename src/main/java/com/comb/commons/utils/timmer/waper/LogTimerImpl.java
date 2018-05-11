package com.comb.commons.utils.timmer.waper;

import com.comb.commons.utils.timmer.pojo.TimePojo;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class LogTimerImpl implements LogTimer{

    private Map<TimePojo,Long> map = new HashMap<TimePojo, Long>();
    private ThreadLocal<LogTimer> logTimerlocal = new ThreadLocal<LogTimer>();
    @Override
    public boolean startMark(TimePojo timePojo, Object... msg) {
        map.put(timePojo,System.currentTimeMillis());
        return true ;
    }

    @Override
    public boolean stop(TimePojo timePojo) {
        return false;
    }

    @Override
    public long getTimer(TimePojo timePojo) {
        long l = System.currentTimeMillis();
        Long aLong = map.get(timePojo);
        return l-aLong;
    }

    @Override
    public boolean destory(TimePojo timePojo) {
        return false;
    }

    public boolean goOn(){
        return false ;
    }

}
