package regex;

import java.util.regex.Pattern;


public class RegexUtil{

    //let phone interval 4 number become *
    public static String phoneIntervalAddStar(String phone){
        return phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
    }
    
    //test the string is phone or not 
    public static boolean testPhone(String phone){
        return Pattern.matches("1[3|4|5|6|7|8]\\d{9}", phone);
    }

    //test email so out! haha
    public static boolean testEmail(String email){
        
        
        return false;
    }

    //test idCard 
    public static boolean testIdCard(String idCard){
        
        return false;
    }
    
    public static void main(String[] args) {
        
       show(testPhone("18903592838")); 
        
    }
    
    //show the result
    public static void show(Object o){
        
        System.out.println(o);
        
    }

    
    
    
}
