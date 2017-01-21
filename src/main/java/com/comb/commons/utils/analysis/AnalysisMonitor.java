package com.comb.commons.utils.analysis;

import com.comb.commons.utils.file.FileUtil;

import java.util.TimerTask;

/**
 * Created by Administrator on 2016/9/20.
 */
public class AnalysisMonitor extends TimerTask {

    private boolean exit  = false ;

    private AnalysisPoJo poJo;
    private AnalysisFile analysisFile;
    private Long memory =new Long(0);
    public AnalysisMonitor(AnalysisFile analysisFile) {
        this.poJo=analysisFile.getPoJo();
    }
    @Override
    public void run() {
        long tempTime = System.currentTimeMillis();
        Long fileMemory = FileUtil.getFileMemory(poJo.getTarget());
        //if(tempTime-poJo.getAnalysisTime()>0&&((fileMemory-this.getMemory())<1024)){//TODO 这里可以进行配置文件化
        if(tempTime-poJo.getAnalysisTime()>0){//TODO 这里可以进行配置文件化
            analysisFile.exit();
        }else {
            this.setMemory(tempTime);
        }
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public boolean isExit() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public AnalysisPoJo getPoJo() {
        return poJo;
    }

    public void setPoJo(AnalysisPoJo poJo) {
        this.poJo = poJo;
    }


}
