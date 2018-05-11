package com.comb.sitecollectmanager.service;

import com.comb.sitecollectmanager.pojo.SiteCollect;

import java.util.List;

/**
 */
public interface SiteCollectManagerService
{
    public Integer addCollect(SiteCollect collect);

    public List<SiteCollect> getListCollect(Integer isUse);

}
