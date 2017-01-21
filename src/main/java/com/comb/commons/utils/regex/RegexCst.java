package com.comb.commons.utils.regex;

/**
 * Created by Administrator on 2016/10/17.
 */
public class RegexCst {
    /**
     * 匹配中文
     */
    public static final String CHINESE = "([\u4e00-\u9fa5]+)";
    /**
     * 匹配中文、字母、数字
     */
    public static final String CHINESE_NUM_CHAR = "[\\u4e00-\\u9fa5\\\\w]+";
    /**
     * 匹配注释里面内容
     * 包括:
     */
    // /***/  /** * * * */
    public static final String ANNOTATION = "(?<!:)\\/\\/.*|\\/\\*(\\s|.)*?\\*\\/";  ;

}
