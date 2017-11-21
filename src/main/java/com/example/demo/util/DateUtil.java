package com.example.demo.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
    //获取当前时间
    public static String getCurrentDate(String template){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

        if (template != null && !template.trim().equals("")){
            simpleDateFormat.applyPattern(template);
        }else {//如果没有给定时间模板，采用默认值
            simpleDateFormat.applyPattern("yyyyMMdd");
        }
        Calendar date = Calendar.getInstance();

        return simpleDateFormat.format(date.getTime());
    }
}
