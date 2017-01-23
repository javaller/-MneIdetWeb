package model;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Home on 13.01.2017.
 */
public class TestTime {

    public static void main(String[] args) {
        Date date = new Date(107, 11,13, 16, 40);
        TimeZone  timeZone = TimeZone.getTimeZone("+8");
    }

}
