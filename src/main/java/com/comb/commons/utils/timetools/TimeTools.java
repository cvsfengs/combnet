package com.comb.commons.utils.timetools;

/**
 * Created by ycfeng on 2016/10/25.
 */

import com.comb.commons.utils.number.NumberUtil;
import com.comb.commons.utils.stringtool.StringTools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by guoqiang on 2015/06/02.
 * 时间工具类
 */
public final class TimeTools {
    private static final long MI_OF_HOUR = 60 * 60 * 1000;//1小时毫秒数
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final String YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";
    private static final String YYYY_MM_DD_HH_MI_SS_S = "yyyy-MM-dd HH:mm:ss.SSS";

    public static Date parseISO(String date) {
        if (date == null) {
            return null;
        }
        date = date.replace('T', ' ');
        return parseYYYY_MM_DD_HH_MI_SS(date);
    }

    public static String format(Date date, String format) {
        if (date == null || format == null) {
            return null;
        }
        SimpleDateFormat sdf = getReusableSDF(format);
        return sdf.format(date);
    }

    public static String format4YYYYMMDD(Date date) {
        return format(date, YYYY_MM_DD);
    }

    public static String formatAllTime(Date date) {
        return format(date, YYYY_MM_DD_HH_MI_SS_S);
    }

    public static String format4YYYYMMDDHHMISS(Date date) {
        return format(date, YYYY_MM_DD_HH_MI_SS);
    }

    public static Date parse(String time, String format) {
        if (StringTools.isEmpty(time)) {
            return null;
        }
        try {
            return getReusableSDF(format).parse(time);
        } catch (ParseException e) {
        }
        return null;
    }

    public static Date parseYYYY_MM_DD(String time) {
        return parse(time, YYYY_MM_DD);
    }

    public static Date parseYYYY_MM_DD_HH_MI_SS(String time) {
        return parse(time, YYYY_MM_DD_HH_MI_SS);
    }


    public static String getNowTimeStr() {
        return format4YYYYMMDDHHMISS(createNowTime());
    }

    /**
     * 克隆一个新的时间对象
     *
     * @param date
     * @return
     */
    public static Date cloneDate(Date date) {
        return new Date(date.getTime());
    }

    /**
     * 创建一个当前时间的时间对象
     *
     * @return
     */
    public static Date createNowTime() {
        return getCalendar().getTime();
    }

    public static String getNowTimeAllStr() {
        return formatAllTime(createNowTime());
    }

    /**
     * 根据年月日创建时间 时分秒默认为0
     *
     * @param year
     * @param month
     * @param date
     * @return
     */
    public static Date createTime(int year, int month, int date) {
        return createTime(year, month, date, 0, 0, 0);
    }

    /**
     * 根据年月日时分秒创建时间
     *
     * @param year
     * @param month
     * @param date
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static Date createTime(int year, int month, int date, int hour, int minute, int second) {
        Calendar calendar = getCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * 时间设置到明天的0点0分0秒
     *
     * @param date
     */
    public static void setNextDay0H0M0S0MS(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, 1);
        date.setTime(calendar.getTimeInMillis());
    }

    /**
     * 设置Date到当天的0点0分0秒0毫秒
     *
     * @param date
     */
    public static void set0H0M0S0MS(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        date.setTime(calendar.getTimeInMillis());
    }

    public static void setLastDay0H0M0S(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.DATE, -1);
        date.setTime(calendar.getTimeInMillis());
    }

    public static void setLastMonth1D0H0M0S(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.add(Calendar.MONTH, -1);
        date.setTime(calendar.getTimeInMillis());
    }

    public static void setDate(Date date, int field, int value) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(field, value);
        date.setTime(calendar.getTimeInMillis());
    }

    /**
     * 返回2个时间中间相差的unit数量
     *
     * @param date1
     * @param date2
     * @param unit
     * @return
     */
    public static long dateDiff(Date date1, Date date2, TimeUnit unit) {
        return (date2.getTime() - date1.getTime()) / unit.toMillis(1);
    }

    /**
     * 得到当前时期是几号
     *
     * @param date
     * @return
     */
    public static int getDateOfMonth(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static int getMonth(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    public static int getYear(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * Description: 获取date在当天的第几个小时
     *
     * @param date
     * @return
     */
    public static int getHours(Date date) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 判断是否是同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        Calendar calendar1 = getCalendar();
        calendar1.setTime(date1);
        Calendar calendar2 = getCalendar();
        calendar2.setTime(date2);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR) &&
                calendar1.get(Calendar.DAY_OF_YEAR) == calendar2.get(Calendar.DAY_OF_YEAR);
    }


    /**
     * 将当前时间增加几分钟
     *
     * @param date
     * @param minute
     * @return
     */
    public static Date addMinutes(Date date, int minute) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();

    }

    /**
     * 比较两个时间大小
     *
     * @param dateA
     * @param dateB
     * @return
     */
    public static Date getBigger(Date dateA, Date dateB) {
        if (dateA.before(dateB))
            return dateB;
        else
            return dateA;
    }

    public static Date parseDate(Object o) {
        if (o instanceof Date) {
            return (Date) o;
        } else if (o instanceof Number) {
            return new Date(((Number) o).longValue());
        } else if (o instanceof String) {
            Long num = NumberUtil.parseLong(o);
            if (num != null) {
                return new Date(num);
            } else {
                String str = o.toString();
                Date date = parse(o.toString(), YYYY_MM_DD_HH_MI_SS_S);
                if (date == null) {
                    date = parseYYYY_MM_DD_HH_MI_SS(str);
                }
                if (date == null) {
                    date = parseYYYY_MM_DD(str);
                }
                return date;
            }
        }
        return null;
    }

    public static void addTimeField(Date date, int timeField, int offset) {
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.add(timeField, offset);
        date.setTime(calendar.getTimeInMillis());
    }

    public static SimpleDateFormat getReusableSDF(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf;
    }

    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    private TimeTools() {
    }
}
