package JavaSimple;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtil {

    public static final String L_FMT = "yyyyMMddHHmmssSSS";

    /*
     * Calendar and Date exchange：
     * Calender to Date --> c.getTime();
     * Date to Calendar --> c.setTime(d);
     * String and date exchange:
     * SimpleDateFormat sdf = new SimpleDateFormat();
     * sdf.parse();
     * sdf.format();  turn 
     */
    
    /*
     * long和date的exchange
     */
    public static String getSystemTime4Long(){
        SimpleDateFormat sdf = new SimpleDateFormat(L_FMT);
        String date = sdf.format(new Date());
        return date;
    }
    
    public static Date getSystemTime(){
        
        try {
        SimpleDateFormat sdf = new SimpleDateFormat(L_FMT);
        Date d = sdf.parse(getSystemTime4Long());
            return d;
        } catch (ParseException e) {
            e.printStackTrace();
        }
          return null;        
    }
    
    /*
     * 就算两个date的时间差
     */
    public int getDif4Day(Date a,Date b){
        
      Calendar c = Calendar.getInstance();
      c.setTime(a);
      Calendar cc = Calendar.getInstance();
      c.setTime(b);
      return c.get(Calendar.DAY_OF_YEAR) - cc.get(Calendar.DAY_OF_YEAR);

    }
    
    
    /*
     *获取今天0点时间 
     */
    public static Calendar getCurrentCalendar(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c;
        
        //System.out.println(c.getTime());//c.getTime() return current date eg：Fri Jul 08 00:00:00 CST 2016
    }
    
    
    
    public void testN(){
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        System.out.println(day);
    }
    
    @Test
    public void nextDay(){
        
        Calendar c = Calendar.getInstance(); 
        c.set(Calendar.DAY_OF_MONTH, -1);
        System.out.println(c.get(Calendar.DAY_OF_MONTH));
    }
   
    @Test
    public void ZeroClock(){
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        System.out.println(cal.getTime());
        
    }
    
    @Test
    public void Test(){
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println(cal.getTime());
        
    }
    
    @Test
    public void longToDate(){
        
        long time = 20160912000000000L;
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        
        try {
           Date d =  sdf.parse(time+"");
           System.out.println(d);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
    public static long getDayStart4Day(long time){
       
       return time/1000000000*1000000000;
        
    }

    public static long getDayStart4Day(Date time){
        
       Calendar c =  Calendar.getInstance();
        c.setTime(time);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(c.getTime()));
    }
    public static long getDayStart4Day(String time){

        return Long.parseLong(time.substring(0, 8)+"000000000");
    }
    
    public static void main(String[] args) {
        
        System.out.println(getDayStart4Day("20160913232523123"));
    }
    
}
