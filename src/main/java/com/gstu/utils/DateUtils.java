package com.gstu.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    public String changeFormatDate(String dateInput){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        java.util.Date date = null;
        try {
            date =  dateFormat.parse(dateInput);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        String resulDate = dateFormat1.format(date);
//        java.util.Date date = null;
//        try {
//            date = dateFormat.parse(dateInput);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
//        return Date.valueOf(dateFormat1.format(date));
        return resulDate;
    }
}
