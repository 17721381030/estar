package com.estar.judgment.evaluation.web.frame.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimestampTool {

    /**
     * 当前时间
     * 
     * @return Timestamp
     */
    public static Timestamp crunttime() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 获取当前时间的字符串
     * 
     * @return String ex:2006-07-07
     */
    public static String getCurrentDate() {
        Timestamp d = crunttime();
        return d.toString().substring(0, 10);
    }

    /**
     * 获取当前时间的字符串
     * 
     * @return String ex:2006-07-07 22:10:10
     */
    public static String getCurrentDateTime() {
        Timestamp d = crunttime();
        return d.toString().substring(0, 19);
    }

    /**
     * 获取指定时间的字符串,只到日期
     * 
     * @param t
     *            Timestamp
     * @return String ex:2006-07-07
     */
    public static String getStrDate(Timestamp t) {
        return t.toString().substring(0, 10);
    }

    /**
     * 获取指定时间的字符串
     * 
     * @param t
     *            Timestamp
     * @return String ex:2006-07-07 22:10:10
     */
    public static String getStrDateTime(Timestamp t) {
        return t.toString().substring(0, 19);
    }

    /**
     * 获得当前日期的前段日期
     * 
     * @param days
     * @return String
     */
    public static String getStrIntervalDate(String days) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -Integer.parseInt(days));
        String strBeforeDays = sdf.format(cal.getTime());
        return strBeforeDays;
    }

    /**
     * 格式化时间
     * 
     * @param dt
     *            String -> yyyy-MM-dd hh:mm:ss
     * @return java.util.Date.Date -> yyyy-MM-dd hh:mm:ss
     */
    public static Date parseDateTime(String dt) {
        Date jDt = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            if (dt.length() >= 19) {
                jDt = sdf.parse(dt);
            }else if(dt.length()>=16){
            	sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            	jDt = sdf.parse(dt);
            }else if(dt.length()>=10){
            	sdf = new SimpleDateFormat("yyyy-MM-dd");
            	jDt = sdf.parse(dt);
            }else{
            	jDt = null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jDt;
    }

    /**
     * 格式化时间yyyy-MM-dd HH:mm:ss
     * 
     * @param date
     *            java.util.Date
     * @return String -> yyyy-MM-dd HH:mm:ss
     */
    public static String parseDateTime(Date date) {
        String s = null;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            s = f.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public static String parseDateSimpleTime(Date date) {
        String s = null;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yy-MM-dd HH:mm");
            s = f.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
    /**
     * 格式化日期
     * 
     * @param dt
     *            String -> yyyy-MM-dd
     * @return java.util.Date.Date -> yyyy-MM-dd
     */
    public static Date parseDate(String dt) {
        Date jDt = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            if (dt.length() >= 8) {
                jDt = sdf.parse(dt);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jDt;
    }

    /**
     * 格式化时间yyyy-MM-dd
     * 
     * @param date
     *            java.util.Date
     * @return String -> yyyy-MM-dd
     */
    public static String parseDate(Date date) {
        String s = null;
        try {
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            s = f.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    
    public static String[] getDateDirPath(String base) throws IOException {
    	Date date = new Date();
        SimpleDateFormat y = new SimpleDateFormat("yyyy");
        SimpleDateFormat m = new SimpleDateFormat("MM");
        SimpleDateFormat d = new SimpleDateFormat("dd");
        String stry = y.format(date);
        String strm = m.format(date);
        String strd = d.format(date);
        
        File fy = new File(base + File.separator+ stry);
        File fm = new File(base + File.separator+ stry+ File.separator+ strm);
        File fd = new File(base + File.separator+ stry+ File.separator+ strm + File.separator+ strd);
        
        if(!fy.exists()){
        	fy.mkdir();
        }
        if(!fm.exists()){
        	fm.mkdir();
        }
        if(!fd.exists()){
        	fd.mkdir();
        }
        String[] returnStr = {"","","",""};
        returnStr[0] = stry;
        returnStr[1] = strm;
        returnStr[2] = strd;
        return  returnStr;
    }
    /**
     * 
     * @param dt
     * @return String
     */
    public static String getLongDateFromShortDate(String dt) {
        String strDT = dt;
        try {
            if (strDT != null && strDT.length() <= 10) {
                strDT = dt.trim() + " 00:00:00";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return strDT;
    }

    /**
     * 
     * @param dt
     * @return String
     */
    @SuppressWarnings("deprecation")
	public static String getShortDateToHHMM(String dt) {
        String jDt = dt;
        try {
            if (jDt != null && jDt.length() <= 10) {
                jDt = jDt + " 00:00";
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            jDt = sdf.parse(jDt).toLocaleString();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jDt;
    }

    /**
     * 
     * @param dateStr
     * @return String
     */
    public static String formatDateToHHMM(String dateStr) {
        String resultDate = null;
        try {
            if (dateStr.length() > 10) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:ss");
                Date date = sdf.parse(dateStr);
                resultDate = sdf.format(date);
            } else
                resultDate = dateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    /**
     * 返回日期 格式:2006-07-05
     * 
     * @param str
     * @return Timestamp
     */
    @SuppressWarnings("deprecation")
	public static Timestamp date(String str) {
        Timestamp tp = null;
        if (str.length() <= 10) {
            String[] string = str.trim().split("-");
            int one = Integer.parseInt(string[0]) - 1900;
            int two = Integer.parseInt(string[1]) - 1;
            int three = Integer.parseInt(string[2]);
            tp = new Timestamp(one, two, three, 0, 0, 0, 0);
        }
        return tp;
    }

    /**
     * 返回时间和日期 格式:2006-07-05 22:10:10
     * 
     * @param str
     * @return Timestamp
     */
    @SuppressWarnings("deprecation")
	public static Timestamp datetime(String str) {
        Timestamp tp = null;
        if (str.length() >= 19) {
            String[] string = str.trim().split(" ");
            String[] date = string[0].split("-");
            String[] time = string[1].split(":");
            int date1 = Integer.parseInt(date[0]) - 1900;
            int date2 = Integer.parseInt(date[1]) - 1;
            int date3 = Integer.parseInt(date[2]);
            int time1 = Integer.parseInt(time[0]);
            int time2 = Integer.parseInt(time[1]);
            int time3 = Integer.parseInt(time[2]);
            tp = new Timestamp(date1, date2, date3, time1, time2, time3, 0);
        }else if (str.length() >= 16) {
            String[] string = str.trim().split(" ");
            String[] date = string[0].split("-");
            String[] time = string[1].split(":");
            int date1 = Integer.parseInt(date[0]) - 1900;
            int date2 = Integer.parseInt(date[1]) - 1;
            int date3 = Integer.parseInt(date[2]);
            int time1 = Integer.parseInt(time[0]);
            int time2 = Integer.parseInt(time[1]);
            tp = new Timestamp(date1, date2, date3, time1, time2, 0, 0);
        }else if (str.length() >= 10) {
            String[] date = str.split("-");
            int date1 = Integer.parseInt(date[0]) - 1900;
            int date2 = Integer.parseInt(date[1]) - 1;
            int date3 = Integer.parseInt(date[2]);
            tp = new Timestamp(date1, date2, date3, 0, 0, 0, 0);
        }
        return tp;
    }

    /**
     * 返回日期和时间(没有秒) 格式:2006-07-05 22:10
     * 
     * @param str
     * @return Timestamp
     */
    @SuppressWarnings("deprecation")
	public static Timestamp datetimeHm(String str) {
        Timestamp tp = null;
        if (str.length() > 10) {
            String[] string = str.trim().split(" ");
            String[] date = string[0].split("-");
            String[] time = string[1].split(":");
            int date1 = Integer.parseInt(date[0]) - 1900;
            int date2 = Integer.parseInt(date[1]) - 1;
            int date3 = Integer.parseInt(date[2]);
            int time1 = Integer.parseInt(time[0]);
            int time2 = Integer.parseInt(time[1]);
            tp = new Timestamp(date1, date2, date3, time1, time2, 0, 0);
        }
        return tp;
    }

    /**
     * 获得当前系统日期与本周一相差的天数
     * 
     * @return int
     */
    private static int getMondayPlus() {
        Calendar calendar = Calendar.getInstance();
        // 获得今天是一周的第几天，正常顺序是星期日是第一天，星期一是第二天......
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 星期日是第一天
        return (dayOfWeek == 1) ? -6 : 2 - dayOfWeek;
    }

    /**
     * 获得距当前时间所在某星期的周一的日期 例： 0-本周周一日期 -1-上周周一日期 1-下周周一日期
     * 
     * @param week
     *            int
     * @return java.util.Date
     */
    public static Date getMondayOfWeek(int week) {
        int mondayPlus = getMondayPlus(); // 相距周一的天数差
        GregorianCalendar current = new GregorianCalendar();
        current.add(GregorianCalendar.DATE, mondayPlus + 7 * week);
        return current.getTime();
    }

    /**
     * 获得某日前后的某一天
     * 
     * @param date
     *            java.util.Date
     * @param day
     *            int
     * @return java.util.Date
     */
    public static Date getDay(Date date, int day) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        c.add(GregorianCalendar.DATE, day);
        return c.getTime();
    }

    /**
     * 获得距当前周的前后某一周的日期(包括上周日)
     * 
     * @param week
     *            int
     * @return String[]
     */
    public static String[] getDaysOfWeek(int week) {
        String[] days = new String[8];
        Date monday = getMondayOfWeek(week); // 获得距本周前或后的某周周一
        // 上周日
        days[0] = getStrDate(new Timestamp(getDay(monday, -1).getTime()));
        days[1] = getStrDate(new Timestamp(monday.getTime()));
        Timestamp t;
        for (int i = 1; i < 7; i++) {
            t = new Timestamp(getDay(monday, i).getTime());
            days[1 + i] = getStrDate(t);
        }
        return days;
    }
    
    /***
     * MCC的UTC时间转换，MCC的UTC不是到毫秒的
     * 
     * @param utc
     * @return java.util.Date
     */
    public static Date mccUTC2Date(long utc) {
        Date d = new Date();
        d.setTime(utc * 1000); // 转成毫秒
        return d;
    }
    
    
    
    public static long mccDate2UTC(String str) {
    	Date d = parseDateTime(str);
        return (long)d.getTime()/(long)1000;
    }
    /*
    public static void main(String[] args) {
        System.out.println(parseDateTime(utc2Date(1279701969)));
        System.out.println(System.currentTimeMillis());
    }
    */
	//	获取当前日期之前的日期字符串 如 2007-04-15  前5月 就是 2006-11-15 
	public static String getPreviousMonth(int month){
		Calendar   cal1   =   Calendar.getInstance();   
        cal1.setTime(new Date());   
        cal1.add(Calendar.MONTH,-month);               
        SimpleDateFormat  formatter = new SimpleDateFormat("yyyy-MM-dd");   
        return formatter.format(cal1.getTime());
    }
	
	 public static boolean getDifferMinute(long utc, int minute) {
        Date newDate = new Date();
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(newDate);
        c.add(GregorianCalendar.MINUTE, -minute);
        return (c.getTime().getTime() - utc*1000)>0?true:false;
    }

	 public static String compareDate(Date nowDate, Date compareD1, Date compareD2) {
		 if(null != compareD1 && null != compareD2){
			 if((nowDate.getTime() > compareD1.getTime()) && (nowDate.getTime() < compareD2.getTime())){
				return "1";
			 }
		 }
		 return "0";
	 }
	 
//		获取指定日期之前的日期字符串 如 2007-04-15 10:00 之后5分钟 就是 2007-04-15 10:05 
		public static Date getCurNextMin(Date tdate,int min){
			Calendar   cal1   =   Calendar.getInstance();   
	        cal1.setTime(tdate);   
	        cal1.add(Calendar.MINUTE,min);                
	        return cal1.getTime();
	    }
}
