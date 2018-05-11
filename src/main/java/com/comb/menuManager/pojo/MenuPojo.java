package com.comb.menuManager.pojo;

import com.comb.commons.utils.annotaion.ModelAnnotation;

/**
 */
@ModelAnnotation(modelVal="菜单管理实体对象")
public class MenuPojo {

    @ModelAnnotation(paramVal = "主键id唯一")
    private Integer pId ;
    @ModelAnnotation(paramVal = "父级菜单名称")
    private String pName  ;
    @ModelAnnotation(paramVal = "是否可用")
    private Integer isUse ;
    @ModelAnnotation(paramVal = "英文名称")
    private String enName ;
    @ModelAnnotation(paramVal = "页面链接")
    private String link ;
    @ModelAnnotation(paramVal = "按钮描述")
    private String menuDesc ;
    @ModelAnnotation(paramVal = "操作类型")
    private String type ;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }


}
