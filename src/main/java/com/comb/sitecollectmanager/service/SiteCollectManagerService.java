package com.comb.sitecollectmanager.service;

import com.comb.sitecollectmanager.pojo.SiteCollect;

import java.util.List;

/**
 * Created by ycfeng on 2016/9/28.
 */
public interface SiteCollectManagerService
{
    public Integer addCollect(SiteCollect collect);

    public List<SiteCollect> getListCollect(Integer isUse);

}
