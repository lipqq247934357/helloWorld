package com.lip.hello.basics;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String L_FMT = "yyyyMMddHHmmssSSS";

    public static String getSystemTime4Long() {
        SimpleDateFormat sdf = new SimpleDateFormat(L_FMT);
        return sdf.format(new Date());
    }

    public static Date getSystemTime() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(L_FMT);
            return sdf.parse(getSystemTime4Long());
        } catch (ParseException e) {
            throw new IllegalStateException("Failed to parse system time", e);
        }
    }

    public static Date getDateByLong(long time) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(L_FMT);
            return sdf.parse(String.valueOf(time));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid time value: " + time, e);
        }
    }

    public static long getDateForLong(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(L_FMT);
        return Long.parseLong(sdf.format(date));
    }

    public static String format(String timeStr) {
        return timeStr.replaceAll(
            "(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{3})",
            "$1-$2-$3 $4:$5:$6.$7");
    }

    public static Calendar getCurrentCalendar() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c;
    }

    public static long getDayStart4Day(long time) {
        return time / 1_000_000_000L * 1_000_000_000L;
    }

    public static long getDayStart4Day(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return Long.parseLong(new SimpleDateFormat(L_FMT).format(c.getTime()));
    }

    public static long getDayStart4Day(String time) {
        return Long.parseLong(time.substring(0, 8) + "000000000");
    }
}
