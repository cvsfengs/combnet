package com.comb.sitecollectmanager.service.impl;

import com.comb.sitecollectmanager.dao.SiteCollectManagerDao;
import com.comb.sitecollectmanager.pojo.SiteCollect;
import com.comb.sitecollectmanager.service.SiteCollectManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 */
@Service
public class SiteCollectManagerServiceImpl implements SiteCollectManagerService
{
    @Autowired
    private SiteCollectManagerDao siteCollectManagerDao;

    @Override
    public Integer addCollect(SiteCollect collect) {
        return siteCollectManagerDao.addCollect(collect);
    }

    @Override
    public List<SiteCollect> getListCollect(Integer isUse)
    {
        return siteCollectManagerDao.getListCollect(isUse);
    }
}
