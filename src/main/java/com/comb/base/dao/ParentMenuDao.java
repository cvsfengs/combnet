package com.comb.base.dao;

import com.comb.base.pojo.ParentMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
@Repository
public interface ParentMenuDao {
    //添加功能菜单
    public Integer addParentMenu(ParentMenu parentMenu) ;
    //获取所有功能菜单
    public List<ParentMenu> getAllParentMenu(Integer isUse) ;
}


