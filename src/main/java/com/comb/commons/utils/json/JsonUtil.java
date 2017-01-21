package com.comb.commons.utils.json;

import com.alibaba.fastjson.JSON;
import com.comb.commons.utils.MarkInterface;

import java.util.List;

/**
 * Created by ycfeng on 2016/7/27.
 * json转换工具类
 */
public class JsonUtil implements MarkInterface {

    /**
     * 任意对象转json
     */
    public static String objectToJson(Object o){

        try {
            return  JSON.toJSONString(o);
        }catch (Exception e){
            return null ;
        }
    }

    /**
     * json转对象
     */
    public static <T> T jsonToObject(String json , Class<T> clazz){
        try {
            if(clazz!=null){
                return JSON.parseObject(json, clazz);
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }

    /**
     *将一个obj转成指定对象
     * 属性必须一一对应
     */
    public static <T> T objecToObject(Object obj , Class<T> clazz){
        try {
           return jsonToObject((String) obj, clazz);
        }catch (Exception e){
            return null;
        }
    }
    public static <T> List<T> toList(String jsonArr, Class<T> clazz){
        try {
            if (clazz != null) {
                return JSON.parseArray(jsonArr, clazz);
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
    /**
     * 打印输入到控制台
     */
    public static void printJson(String jsonStr){
        System.out.println(formatJson(jsonStr));
    }

    /**
     * 格式化
     */
    public static String formatJson(String jsonStr) {

        if (null == jsonStr || "".equals(jsonStr)) return "";
        StringBuilder sb = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        for (int i = 0; i < jsonStr.length(); i++) {
            last = current;
            current = jsonStr.charAt(i);
            switch (current) {
                case '{':
                case '[':
                    sb.append(current);
                    sb.append('\n');
                    indent++;
                    addIndentBlank(sb, indent);
                    break;
                case '}':
                case ']':
                    sb.append('\n');
                    indent--;
                    addIndentBlank(sb, indent);
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\') {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }

        return sb.toString();
    }

    /**
     * 添加space
     */
    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }

}
