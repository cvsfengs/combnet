package com.comb.commons.utils.translate;

import com.comb.commons.utils.translate.language.Language;

/**
 * Created by ycfeng on 2016/9/23.
 */
public class Main {

    public static void main(String[] args) {
        String name = TranslateUtil.doTranslate("李改霞", Language.ZH_CN, Language.EN_US);
        String en = TranslateUtil.doTranslate("survey", Language.EN_US, Language.ZH_CN);

        System.out.println(name);
        System.out.println(en);


    }

}
