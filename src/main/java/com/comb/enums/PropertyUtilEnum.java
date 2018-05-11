package com.comb.enums;

/**
 */
public enum PropertyUtilEnum {

    MYSQLCONF("mysqlconf.properties"),
    RABBITMQ("mq.properties"),
    REDISCONF("redis.properties"),
    FTPCONF("ftp.properties"),
    ANALYSIS("analysis.properties"),
    TRANSLATE("translate.properties"),
    JAVAMAIL("mail.properties")

    ;



    private String propName ;
    private Object propVal  ;

    private PropertyUtilEnum(){};
    private PropertyUtilEnum(String propName,Object propVal){
        this.propName=propName;
        this.propVal=propVal;
    };
    private PropertyUtilEnum(String propName){
        this.propName=propName;
    };

    public String getPropName() {
        return propName;
    }

    public void setPropName(String propName) {
        this.propName = propName;
    }

    public Object getPropVal() {
        return propVal;
    }

    public void setPropVal(Object propVal) {
        this.propVal = propVal;
    }
}
