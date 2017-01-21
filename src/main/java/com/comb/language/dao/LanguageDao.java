package com.comb.language.dao;

import com.comb.language.pojo.Language;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
@Repository
public interface LanguageDao {
    /**
     * 获取语言框
     */
    List<Language> getLanguageList(Integer isUse);
}
