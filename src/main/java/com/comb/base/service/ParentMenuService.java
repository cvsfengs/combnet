package com.comb.base.service;

import com.comb.base.dao.ParentMenuDao;
import com.comb.base.pojo.ParentMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/13.
 */
@Service
public class ParentMenuService {
    @Autowired
    private ParentMenuDao parentMenuDao ;

    public Integer addParentMenu(ParentMenu parentMenu){
       return this.parentMenuDao.addParentMenu(parentMenu);
    }
    public List<ParentMenu> getAllParentMenu(Integer isUse){
       return this.parentMenuDao.getAllParentMenu(isUse);
    }
}
