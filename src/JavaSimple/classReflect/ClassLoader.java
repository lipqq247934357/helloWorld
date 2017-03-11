package JavaSimple.classReflect;

import java.lang.reflect.Field;
/**
 * 
 * @Description: 获取所有的属性，无论是否私有
 * @Author TigerYoung1
 * @Date 2016年7月29日 下午3:50:18
 */
public class ClassLoader {

    public static void main(String[] args) {

        int i = 0;

        try {
            Class clazz = Class.forName("JavaSimple.classReflect.OperationReportDay");
            Field[] fileds = clazz.getDeclaredFields(); //jdk是最核心的
            System.out.println(fileds.length);
            switch (i) {
            case 0:
                for (Field filed : fileds) {
                    System.out.println("<td>{{x." + filed.getName() + "}}</td>");
                };
                break;
            case 1:
                for (Field filed : fileds) {
                    System.out.println("var "+ filed.getName() + "= []");
                };
                break;
            case 2:
                for (Field filed : fileds) {
                    System.out.println("<br>" + filed.getName() + "</br>");
                };
                break;
            case 3:
                for (Field filed : fileds) {
                    System.out.println("<br>" + filed.getName() + "</br>");
                };
                break;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    
}
