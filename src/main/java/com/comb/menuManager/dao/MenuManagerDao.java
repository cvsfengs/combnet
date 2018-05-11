package com.comb.menuManager.dao;

import com.comb.commons.pojo.EasyUIRequestPagination;
import com.comb.menuManager.pojo.MenuPojo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单管理dao
 */
@Repository
public interface MenuManagerDao {
    /**
     * 菜单新增
     */
    public Integer menuAdd(MenuPojo menuPojo);

    /**
     * 删除菜单,传入菜单id
     */
    public Integer menuRemove(Integer menuId);

    /**
     * 查询菜单,依据菜单关键字
     */
    public List<MenuPojo> menuSearch(EasyUIRequestPagination menuPojo);
    /**
     * 菜单修改
     */
    public Integer menuModify(MenuPojo menuPojo);

    /**
     * 菜单总数
     */
    public Integer menuCount();
}
