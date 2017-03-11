package JavaSimple.javaBasic.DateTime;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.twotiger.util.DateUtil;

public class HelloWorld {

    @Test
    public void demo(){
        //TODO 对日期的处理
        
    }
    
    //需求：将long类型转化为calendar，计算它7天后的日期，再将calendar转化成date,将time转化成long
    @Test
    public void test(){
        long investTime = 20161220211256999L;
        Date d = DateUtil.getDateByLong(investTime);
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.DAY_OF_MONTH, 7);
        long endTime = DateUtil.getDateForLong(c.getTime());
    }
    
    //获取当月第一天，最后一天，上个月第一天，最后一天
    @Test
    public void test2(){
    
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long curBegin = DateUtil.getDateForLong(c.getTime());
        c.add(Calendar.MONTH, -1);
        long preBegin = DateUtil.getDateForLong(c.getTime());
        c.add(Calendar.MONTH, 2);
        c.add(Calendar.SECOND, -1);
        long curEnd = DateUtil.getDateForLong(c.getTime());
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        c.add(Calendar.SECOND, -1);
        long preEnd = DateUtil.getDateForLong(c.getTime());
        System.out.println("preBegin:"+preBegin);
        System.out.println("preEnd:"+preEnd);
        System.out.println("currBegin:"+curBegin);
        System.out.println("curEnd:"+curEnd);
    }
}
