package com.comb.menuManager.service;

import com.comb.commons.pojo.EasyUIRequestPagination;
import com.comb.commons.pojo.EasyUIResponsePagination;
import com.comb.menuManager.dao.MenuManagerDao;
import com.comb.menuManager.pojo.MenuPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ycfeng on 2016/8/16.
 * 菜单管理service层
 */
@Service
public class MenuManagerService {
    @Autowired
    private MenuManagerDao menuManagerDao;

    /**
     * 添加
     */
    @Transactional
    public Integer menuUpdate(MenuPojo menuPojo){
        if(menuPojo.getType().equals("add")){
            return menuManagerDao.menuAdd(menuPojo);
        }else{
            return menuManagerDao.menuModify(menuPojo);
        }
    }

    /**
     * 删除
     */
    public Integer menuRemove(Integer menuId){
        return menuManagerDao.menuRemove(menuId);
    }

    /**
     * 查询
     */
    public EasyUIResponsePagination menuSearch(EasyUIRequestPagination menuPojo){
        List<MenuPojo> menuPojos = menuManagerDao.menuSearch(menuPojo);
        Integer integer = menuManagerDao.menuCount();
        EasyUIResponsePagination responsePagination = new EasyUIResponsePagination();
        responsePagination.setRows(menuPojos);
        responsePagination.setTotal(integer);
        return responsePagination;
    }

    /**
     * 菜单修改
     */
    public Integer menuModify(MenuPojo menuPojo){
        return menuManagerDao.menuModify(menuPojo);
    }

}
