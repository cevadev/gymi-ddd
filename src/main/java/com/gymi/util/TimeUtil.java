package com.gymi.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
    public static int getHoursBetween(Timestamp start, Timestamp end){
        boolean negative = false;
        if (end.before(start))
        {
            negative = true;
            Timestamp temp = start;
            start = end;
            end = temp;
        }

        Instant dtStart = Instant.ofEpochMilli(start.getTime());
        Instant dtEnd = Instant.ofEpochMilli(end.getTime());

        Timestamp dt1 = new Timestamp(dtStart.toEpochMilli());
        Timestamp dt2 = new Timestamp(dtEnd.toEpochMilli());

        long differenceInMillis = dt2.getTime() - dt1.getTime();
        return (int) differenceInMillis / (1000 * 60 * 60);
    }

    public static void main(String[] args) {
        Date dt1 = new Date(2024, Calendar.MAY, 25, 23, 0, 0);
        Timestamp st1 = new Timestamp(dt1.getTime());
        Date st2 = new Date(2024, Calendar.MAY, 21, 21, 0, 0);
        Timestamp stEnd = new Timestamp(st2.getTime());

        System.out.println(getHoursBetween(st1, stEnd));
    }
}
