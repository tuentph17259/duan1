/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author NGUYEN TRI TUE
 */
public class dateHelper {
    static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //Chuyển String sang data
    public static Date toDate(String date,String...pattern){
        try {
            if(pattern.length>0)simpleDateFormat.applyPattern(pattern[0]);
            if(date==null)return dateHelper.now();
            return simpleDateFormat.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex); 
        }
    }
    //Chuyển date sang String
    public static String toString(Date date, String...pattern){
        if(pattern.length>0)simpleDateFormat.applyPattern(pattern[0]);
        if(date==null)date=dateHelper.now();
        return simpleDateFormat.format(date);
    }
    //Lấy giờ hiện tại
    public static Date now() {
        return new Date();   
    }
    //thêm 1 số ngày vào mốc thời gian hiện tại
    public static Date add(int days){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH,days);
        return cal.getTime();
    }
    //thêm 1 số ngày vào mốc thời gian
    public static  Date addDays(Date date, int days){
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH,days);
        return cal.getTime();
    }
}
