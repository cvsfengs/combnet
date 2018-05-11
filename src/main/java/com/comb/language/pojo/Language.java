package com.comb.language.pojo;

/**
 */
public class Language {
    /**
     * 主键id
     */
    private Integer id ;
    /**
     * 英文名称
     */
    private String eName ;
    /**
     * 中文名称s
     */
    private String cName ;
    /**
     * 是否可用 1可用 0 无效
     */
    private Integer isUse ;

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }
}
