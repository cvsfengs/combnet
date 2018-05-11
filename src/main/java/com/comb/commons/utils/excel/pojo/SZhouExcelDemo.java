package com.comb.commons.utils.excel.pojo;

/**
 * Created by ycfeng on 2016/9/6.
 */
public class SZhouExcelDemo {
    /**
     * 客户编码
     */
    private String memberCode ;
    /**
     * 客户姓名
     */
    private String memberName ;

    /**
     * 联系方式
     */
    private Integer memberMobile;
    /**
     * 客户级别
     */
    private String memberLevel ;
    /**
     * 信息渠道
     */
    private String msgChannel;
    /**
     * 潜客来源
     */
    private String qiankelaiyuan ;
    /**
     * 到店次数
     */
    private Integer comeCount ;
    /**
     * 跟进次数
     */
    private Integer followCount;
    /**
     * 首次到店日期
     */
    private String firstDate ;
    /**
     * 最近跟进时间
     */
    private String nextDate ;
    /**
     * 最近跟时间
     */
    private String preTime ;
    /**
     * 预约看车时间
     */
    private String yuyuekancheshijian ;
    /**
     * 购车门店
     */
    private String byStore ;
    /**
     * 所属门店
     */
    private String inStore;
    /**
     * 当前所属人
     */
    private String currentMember ;

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(Integer memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(String memberLevel) {
        this.memberLevel = memberLevel;
    }

    public String getMsgChannel() {
        return msgChannel;
    }

    public void setMsgChannel(String msgChannel) {
        this.msgChannel = msgChannel;
    }

    public String getQiankelaiyuan() {
        return qiankelaiyuan;
    }

    public void setQiankelaiyuan(String qiankelaiyuan) {
        this.qiankelaiyuan = qiankelaiyuan;
    }

    public Integer getComeCount() {
        return comeCount;
    }

    public void setComeCount(Integer comeCount) {
        this.comeCount = comeCount;
    }

    public Integer getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Integer followCount) {
        this.followCount = followCount;
    }

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getNextDate() {
        return nextDate;
    }

    public void setNextDate(String nextDate) {
        this.nextDate = nextDate;
    }

    public String getPreTime() {
        return preTime;
    }

    public void setPreTime(String preTime) {
        this.preTime = preTime;
    }

    public String getYuyuekancheshijian() {
        return yuyuekancheshijian;
    }

    public void setYuyuekancheshijian(String yuyuekancheshijian) {
        this.yuyuekancheshijian = yuyuekancheshijian;
    }

    public String getByStore() {
        return byStore;
    }

    public void setByStore(String byStore) {
        this.byStore = byStore;
    }

    public String getInStore() {
        return inStore;
    }

    public void setInStore(String inStore) {
        this.inStore = inStore;
    }

    public String getCurrentMember() {
        return currentMember;
    }

    public void setCurrentMember(String currentMember) {
        this.currentMember = currentMember;
    }
}
