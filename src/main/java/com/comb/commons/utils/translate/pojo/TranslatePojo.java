package com.comb.commons.utils.translate.pojo;

import java.util.List;

/**
 * Created by ycfeng on 2016/9/23.
 * 调用百度api翻译接口回参对象
 */
public class TranslatePojo {
    /**
     * 翻译语言(源)
     */
    private String from ;
    /**
     * 翻译语言(目标)
     */
    private String to ;
    /**
     * 翻译结果
     */
    private List<TransResult> trans_result ;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<TransResult> getTrans_result() {
        return trans_result;
    }

    public void setTrans_result(List<TransResult> trans_result) {
        this.trans_result = trans_result;
    }
}
