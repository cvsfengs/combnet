package com.comb.language.service;

import com.comb.language.pojo.Language;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
public interface LanguageService {

    List<Language> getLanguageList(Integer isUse);

}
