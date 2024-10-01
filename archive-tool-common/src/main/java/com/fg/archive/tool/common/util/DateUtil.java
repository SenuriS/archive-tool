package com.fg.archive.tool.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static  String YYYY_MM_DD_SEPERATED_SLASH="yyyy-MM-dd";
    public static  String YYYY_MM_DD_HHMMSS_SEPERATED_SLASH="yyyy-MM-dd HH:mm:ss";

    public static Calendar getCalendar(final String dateStr, final String dateFormat){
        DateFormat df = new SimpleDateFormat(dateFormat);
        Calendar cal = Calendar.getInstance();
        try{

            cal.setTime(df.parse(dateStr));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return cal;
    }

    public static final String getDate(final String format,final Calendar calendar){
        Date date = calendar.getTime();
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    public static Calendar addDays(Calendar calendar, int days){
        calendar.add(Calendar.DATE,days);
        return calendar;
    }

    public static Calendar toMidNight(final Calendar date){
        Calendar cal = Calendar.getInstance();
        cal.set(date.get(Calendar.YEAR),date.get(Calendar.MONTH),date.get(Calendar.DAY_OF_MONTH),0,0,0);
        return cal;
    }

}
