//package com.xuser.commons.utils.json;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.serializer.ValueFilter;
//import com.xuser.commons.utils.stringtool.StringTools;
//import com.xuser.commons.utils.timetools.TimeTools;
//
//import java.util.Date;
//
//import static com.alibaba.fastjson.serializer.SerializerFeature.*;
//public class JSONUtils implements ValueFilter {
//
//    private static final JSONUtils ME = new JSONUtils();
//
//    public static <T> T transform(Object obj, Class<T> t) {
//        return parseObject(JSON.toJSONString(obj), t);
//    }
//
//    public static String easy(Object o) {
//        return JSON.toJSONString(o, ME);
//    }
//
//
//    public static String toString(Object o) {
//        return toString(o, UseISO8601DateFormat);
//    }
//
//    public static String toStringNative(Object o) {
//        return JSON.toJSONString(o);
//    }
//
//    public static String toStringC(Object o) {
//        return toString(o, UseISO8601DateFormat, WriteClassName);
//    }
//
//    public static String toString(Object o, SerializerFeature... features) {
//        return JSON.toJSONString(o, features);
//    }
//
//    public static <T> T parseObject(String text, Class<T> clazz) {
//        return JSON.parseObject(text, clazz);
//    }
//
//    public static JSONObject parseJSON(String text) {
//        return JSON.parseObject(text);
//    }
//
//    public static String toStringWithNull(Object o) {
//        return toString(o, WriteMapNullValue, UseISO8601DateFormat);
//    }
//
//    private JSONUtils() {
//
//    }
//
//    @Override
//    public Object process(Object o, String s, Object o1) {
//        if (o1 instanceof String || o1 instanceof StringBuffer || o1 instanceof StringBuilder
//                || o1 instanceof StackTraceElement) {
//            return o1.toString();
//        } else if (o1 instanceof Date) {
//            return TimeTools.formatAllTime((Date) o1);
//        } else if (o1 instanceof Throwable) {
//            return StringTools.toString((Throwable) o1);
//        }
//        return JSON.toJSON(o1);
//    }
//}
