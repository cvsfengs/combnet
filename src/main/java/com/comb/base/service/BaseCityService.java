package com.comb.base.service;

import com.comb.base.dao.BaseCityDao;
import com.comb.base.pojo.BaseCity;
import com.comb.commons.pojo.EasyUIRequestPagination;
import com.comb.commons.pojo.EasyUIResponsePagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
@Service
public class BaseCityService {
    @Autowired
    private BaseCityDao baseCityDao ;

    public EasyUIResponsePagination getBaseCity(EasyUIRequestPagination pagination){
        List<BaseCity> citys = baseCityDao.getCitys(pagination);
        int citysCount = baseCityDao.getCitysCount();
        EasyUIResponsePagination responsePagination = new EasyUIResponsePagination();
        responsePagination.setRows(citys);
        responsePagination.setTotal(citysCount);
        return responsePagination;
    }
    public int getCitysCount(){
        return baseCityDao.getCitysCount();
    }

    public int testCount(){
        return baseCityDao.testCount();
    }


}
