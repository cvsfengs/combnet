package com.comb.commons.utils.translate;

import com.comb.commons.utils.http.HttpUtils;
import com.comb.commons.utils.json.JsonUtil;
import com.comb.commons.utils.property.PropertyUtil;
import com.comb.commons.utils.translate.pojo.TranslatePojo;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * 翻译工具类
 */
public class TranslateUtil {

    private static final String TRANSLATEAPPID = PropertyUtil.getValueByKey("translateAPPID");
    private static final String TRANSLATESECKEY = PropertyUtil.getValueByKey("translateSecKey");
    private static final String TRANSLATEAPIHOST = PropertyUtil.getValueByKey("translateAPIHost");
    private static final String TRANSLATESALT = PropertyUtil.getValueByKey("translateSalt");

    /**
     * @param q 目标串
     * @return  翻译 结果
     * TODO 只是实现翻译功能,没有进行更为详尽判断
     */
    public static String doTranslate(String q,String from,String to){
        String sign = getSign(q);
        String content = "" ;
        StringBuffer url = new StringBuffer();
        url.append(TRANSLATEAPIHOST)
            .append("?q=" + q)
            .append("&from=" + from)
            .append("&to=" + to)
            .append("&appid=" + TRANSLATEAPPID)
            .append("&salt=" + TRANSLATESALT)
            .append("&sign=" + sign);
        String result = HttpUtils.doGet(url.toString());

        TranslatePojo translatePojo = JsonUtil.jsonToObject(result, TranslatePojo.class);
        if(translatePojo.getTrans_result()!=null){
            content  = translatePojo.getTrans_result().get(0).getDst();
        }
        return content ;
    }

    /**
     * 进行utf-8 编码转换
     * TODO 此处方法并未进行功能化实现,预置方法
     */
    public static String enCodeUTF8(Object str){
        if(str instanceof String) {
            String tempString = (String) str;
            return tempString;
        }
         return null ;
    }
    /**
     * 获取签名
     */
    private static String getSign(String q){
        StringBuffer buffer = new StringBuffer();
        StringBuffer append = buffer.append(TRANSLATEAPPID).append(q).append(TRANSLATESALT).append(TRANSLATESECKEY);
        String str = append.toString();
        try {
            str = new String(append.toString().getBytes(),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return  DigestUtils.md5Hex(str);
    }

}
