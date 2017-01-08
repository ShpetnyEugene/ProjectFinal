package com.gstu.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {

    /**
     * The method converts the date format with an incorrect date in the desired format
     *
     * @param dateInput - Date format, which is malformed
     * @return The date having the desired format, for further use
     * @throws ParseException - if the date can not be formatted
     */
    public String changeFormatDate(String dateInput) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date date = null;
        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat1.format(date);
    }
}
