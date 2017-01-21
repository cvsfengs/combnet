package com.comb.language.service.impl;

import com.comb.language.dao.LanguageDao;
import com.comb.language.pojo.Language;
import com.comb.language.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageDao languageDao ;
    @Override
    public List<Language> getLanguageList(Integer isUse) {
        return languageDao.getLanguageList(isUse);
    }
}
