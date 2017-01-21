package com.comb.commons.utils.analysis;

import java.io.File;

/**
 * Created by Administrator on 2016/9/20.
 */
public class AnalysisPoJo {

    /**
     * 分析起始时间
     */
    private Long analysisTime ;
    /**
     * 是否进行系统退出
     */
    private Boolean sysExit;
    /**
     * 输出文件
     */
    private File target ;

    public File getTarget() {
        return target;
    }

    public void setTarget(File target) {
        this.target = target;
    }

    public Long getAnalysisTime() {
        return analysisTime;
    }

    public void setAnalysisTime(Long analysisTime) {
        this.analysisTime = analysisTime;
    }

    public Boolean getSysExit() {
        return sysExit;
    }

    public void setSysExit(Boolean sysExit) {
        this.sysExit = sysExit;
    }
}
