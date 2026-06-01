package com.lip.hello.basics;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateUtilTest {

    @Test
    void convertsLongToDateAndBack() {
        long investTime = 20161220211256999L;
        Date date = DateUtil.getDateByLong(investTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        long endTime = DateUtil.getDateForLong(calendar.getTime());
        assertTrue(endTime > investTime);
    }

    @Test
    void formatsTimestampString() {
        String formatted = DateUtil.format("20161212235959000");
        assertEquals("2016-12-12 23:59:59.000", formatted);
    }

    @Test
    void getsDayStartFromString() {
        assertEquals(20160913000000000L, DateUtil.getDayStart4Day("20160913232523123"));
    }
}
