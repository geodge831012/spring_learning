package com.dengtacj.news.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2019/10/28 0028.
 */

public class DateUtil {
    /**
     * 一天包含的毫秒数
     */
    public static final Long DAY_MILLIS = 24 * 60 * 60 * 1000L;

    /**
     * get first date of given month and year
     * @param year
     * @param month
     * @return
     */
    public static String getFirstDayOfMonth(int year,int month){
        String monthStr = month < 10 ? "0" + month : String.valueOf(month);
        return year + "-"+monthStr+"-" +"01";
    }

    /**
     * get the last date of given month and year
     * @param year
     * @param month
     * @return
     */
    public static String getLastDayOfMonth(int year,int month){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR , year);
        calendar.set(Calendar.MONTH , month - 1);
        calendar.set(Calendar.DATE , 1);
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.DAY_OF_YEAR , -1);
        return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" +
                calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * get Calendar of given year
     * @param year
     * @return
     */
    private static Calendar getCalendarFormYear(int year){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cal.set(Calendar.YEAR, year);
        return cal;
    }

    /**
     * get start date of given week no of a year
     * @param year
     * @param weekNo
     * @return
     */
    public static String getStartDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +
                cal.get(Calendar.DAY_OF_MONTH);

    }

    /**
     * get the end day of given week no of a year.
     * @param year
     * @param weekNo
     * @return
     */
    public static String getEndDayOfWeekNo(int year,int weekNo){
        Calendar cal = getCalendarFormYear(year);
        cal.set(Calendar.WEEK_OF_YEAR, weekNo);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" +
                cal.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * 将date类型转为日期字符串
     * @param date
     * @param fmt
     * @return
     */
    public static String date2str(Date date, String fmt)
    {
        if (fmt == null){
            fmt = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat df = new SimpleDateFormat(fmt);
        return df.format(date);
    }

    /**
     * 将日期字符串转为Date类型
     * @param dateStr
     * @param fmt
     * @return
     * @throws ParseException
     */
    public static Date str2date(String dateStr, String fmt) throws ParseException {
        if (fmt == null){
            fmt = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(fmt);
        Date date = sdf.parse(dateStr);
        return date;
    }

    /**
     * 将日期格式转为unix时间戳
     * @param dateStr
     * @param fmt
     * @return
     * @throws ParseException
     */
    public static Long str2TimeSeconds(String dateStr, String fmt) throws ParseException {
        if(dateStr == null || dateStr.isEmpty()) {
            return 0L;
        }
        Date date = str2date(dateStr, fmt);
        return date.getTime()/1000;
    }

    /**
     * 将unix时间戳转为日期格式
     * @param timeStamp
     * @param fmt
     * @return
     */
    public static String timeSeconds2str(long timeStamp, String fmt) {
        Date date = new Date(timeStamp * 1000);
        return date2str(date, fmt);
    }

    /**
     * 获取某个日期间隔几天的日期
     * @param currDate
     * @param deltaDay
     * @return
     * @throws ParseException
     */
    public static String getDateWithDeltaDay(String currDate, int deltaDay) throws ParseException{
        Date date = str2date(currDate, "yyyy-MM-dd");
        Long timestamp = date.getTime() + deltaDay * DAY_MILLIS;
        return date2str(new Date(timestamp), "yyyy-MM-dd");
    }

    /**
     * 获取今日起始时间
     * @return
     */
    public static Date getTodayStartTime() {
        Calendar todayStart = Calendar.getInstance();
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

}
