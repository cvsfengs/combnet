package com.comb.language.controller;

import com.comb.commons.utils.result.DefaultViewResult;
import com.comb.commons.utils.translate.TranslateUtil;
import com.comb.commons.utils.translate.pojo.TransResult;
import com.comb.language.pojo.Language;
import com.comb.language.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2016/9/23.
 */
@Controller
@RequestMapping("/language")
public class LanguageController {
    @Autowired
    private LanguageService languageService ;
    @RequestMapping("getLanguage")
    public void getLanguage(HttpServletRequest request,HttpServletResponse response){
        List<Language> languageList = languageService.getLanguageList(1);
        DefaultViewResult.defaultResult(response, languageList);
    }
    @RequestMapping("doTranslate")
    public void doTranslate(HttpServletRequest request,HttpServletResponse response){
        String fromId = request.getParameter("fromId");
        String toId = request.getParameter("toId");
        String fromValue = request.getParameter("fromValue").trim();
        String dst = TranslateUtil.doTranslate(fromValue, fromId, toId);
        TransResult result = new TransResult();
        result.setDst(dst);
        DefaultViewResult.defaultResult(response,result);
    }
}
