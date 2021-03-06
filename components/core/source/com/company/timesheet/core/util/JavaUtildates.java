/**
 * 
 */
package com.company.timesheet.core.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author vaish
 * 
 */
public class JavaUtildates {

    /**
     * 
     * @param sting
     * @return
     */
    public static Date stringToDateConversion(String sting) {

        java.util.Date date;
        java.sql.Date sqlDate = null;
        try {
            date = new SimpleDateFormat("MM-dd-yyyy").parse(sting);
            sqlDate = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return sqlDate;

    }

    /**
     * 
     * @return
     */
    public static String getCurrentDateTime() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        // get current date time with Date()
        Date date = new Date();
        String crrentDateTime = dateFormat.format(date);
        // System.out.println(crrentDateTime);

        /*
         * //get current date time with Calendar() Calendar cal =
         * Calendar.getInstance();
         * System.out.println(dateFormat.format(cal.getTime()));
         */
        return crrentDateTime;
    }

    /**
     * 
     * @param uDate
     * @return
     */
    public static java.sql.Date convertUtilToSql(java.util.Date uDate) {

        java.sql.Date sDate = null;
       
        if (uDate != null){
           
             sDate = new java.sql.Date(uDate.getTime());
        }else{
            sDate = null;
        }

        return sDate;
    }

    /**
     * 
     * @param date
     * @return
     */
    public static java.sql.Date addDays(java.sql.Date date, long days) {

        long value = (date.getTime() + days * 86400000L);
        
        java.sql.Date sDate = new java.sql.Date(value);
        
        return sDate;

    }
    
    public static int getIntegerDayFromGivenDate(java.util.Date Date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(Date);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }
    public static String getDayFromGivenDate(java.util.Date Date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(Date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEEE");
        String dayOfWeek = dateFormat.format(c.getTime());
        return dayOfWeek;
    }

}
