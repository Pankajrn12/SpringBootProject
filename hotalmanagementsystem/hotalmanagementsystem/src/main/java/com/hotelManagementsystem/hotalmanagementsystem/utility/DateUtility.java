package com.hotelManagementsystem.hotalmanagementsystem.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtility {
    private DateUtility() {

    }
    private static String dtpatern = "yyyy-MM-dd HH:mm:ss.SSS";

    public static Date getCurrentDate() {
        String dtstr = LocalDateTime.now().format(DateTimeFormatter.ofPattern(dtpatern));
        DateFormat dateFormat = new SimpleDateFormat(dtpatern);
        Date date = null;
        try {
            date = dateFormat.parse(dtstr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }
}
