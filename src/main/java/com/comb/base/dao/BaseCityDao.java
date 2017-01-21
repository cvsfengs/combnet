package com.comb.base.dao;

import com.comb.base.pojo.BaseCity;
import com.comb.commons.pojo.EasyUIRequestPagination;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
@Repository
public interface BaseCityDao {
   /**
    * 分页对象
    */
   List<BaseCity> getCitys (EasyUIRequestPagination pagination);

   /**
    * 总共多少题条
    */
   int getCitysCount();

   int testCount();

}
