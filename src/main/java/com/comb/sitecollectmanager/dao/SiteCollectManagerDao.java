package com.comb.sitecollectmanager.dao;

import com.comb.sitecollectmanager.pojo.SiteCollect;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 */
@Repository
public interface SiteCollectManagerDao
{
    public Integer addCollect(SiteCollect collect);

    public List<SiteCollect> getListCollect(Integer isUse);


}
