package JavaSimple.JavaEnums;

import com.twotiger.constant.ActConfig;
import com.twotiger.util.DateUtil;

public class HelloWorld4Enums {

    public static void main(String[] args) {

        for(int i = 0;i < ActConfig.values().length;i++){
            ActConfig actConfig = ActConfig.values()[i];
            System.out.println("活动nid为"+actConfig.getNid()+"的活动的开始时间为："+DateUtil.format(actConfig.getStartTime()+"")+"活动结束时间是"+DateUtil.format(actConfig.getEndTime()+""));
        }
        
    }
    

}
