package com.example.demo.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {


    public static final String SQL_DATE_TYPE_ONE = "%Y-%m-%d";

    public static final String SQL_DATE_TYPE_TWO = "%m-%d";

    public static final String SQL_DATE_TYPE_THREE = "%Y";

    public static final String DATE_TYPE_ONE = "yyyy-MM-dd";

    public static final String DATE_TYPE_TWO = "MM-dd";

    public static final String DATE_TYPE_THREE = "yyyy";

    public static final int REDUCE_DAY_SEVEN = 7;

    public static final int REDUCE_DAY_THIRTY = 30;

    /**
     * 获取当前时间最近 n 天的不同类型的时间
     * @param day
     * @param dayType
     * @return
     * @throws ParseException
     */
    public static List getRangeDateTime(Integer day,String dayType) throws ParseException {
        List dateList = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat(dayType);
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DATE,1);
        Date startTime = calendar.getTime();
        calendar.add(Calendar.DATE, -day);
        Date endTime = calendar.getTime();
        calendar = Calendar.getInstance();
        calendar.setTime(endTime);
        while (!calendar.getTime().equals(startTime)) {
            dateList.add(sdf.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1);
        }
        return dateList;
    }

//     public static void main(String[] args) throws ParseException {
//        List tempList =  getIpAddr();
//        for (int i = 0;i<tempList.size();i++){
//            System.out.print(tempList.get(i)+" ");
//        }
//     }
}
