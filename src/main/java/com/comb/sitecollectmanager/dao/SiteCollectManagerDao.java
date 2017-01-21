package com.comb.sitecollectmanager.dao;

import com.comb.sitecollectmanager.pojo.SiteCollect;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ycfeng on 2016/9/28.
 */
@Repository
public interface SiteCollectManagerDao
{
    public Integer addCollect(SiteCollect collect);

    public List<SiteCollect> getListCollect(Integer isUse);


}
