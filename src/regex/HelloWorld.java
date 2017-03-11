package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class HelloWorld {

    @Test
    public void demo1(){
        String phone = "18903592838";
        System.out.println(phone.replaceFirst("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
    }
    
    @Test
    public void common(){
        //style1：directly，every times new a new object
        Pattern.matches(".","aaa");
        
        //style2 indirect，not every times new a new object
        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        System.out.println(m.replaceAll("aaa"));
    }
    
    //小数，包含整数
    @Test
    public void demo3(){
        System.out.println(Pattern.matches("\\d+(.\\d{0,5})?", "33.556"));
        
    }

    @Test
    public void hehex(){
        if (!Pattern.matches(".",null)) {
           System.out.println("aaaaaaa");
        }
    }        
    //给所有的数字增加引号
    @Test
    public void demo4(){
        String str = "{{5000,1},{10000,2},{30000,4},{50000,5},{100000,12},{200000,24},{300000,26},{500000,54}};";
        System.out.println(str.replaceAll("(\\d+)", "\"$1\""));
    }

    //去掉一个包含多个某个字符的字符串的最后一部分
    @Test
    public void test5(){
        
        String str = "s-2-3-3-4sdfsf-5d-d3";
        String[] strs = str.split("-");
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<strs.length-1;i++){
            if(i == strs.length-2){
                sb.append(strs[i]);
            }else{
                sb.append(strs[i]+"-");
            }
        }
        System.out.println(sb.toString());
    }
    
    //将long类型的时间转换成年月日时分秒的时间，各种转换
    
    @Test
    public void test6(){
     
        long time = 20161212235959000L;
        
        String timeStr = time + "";
        
        System.out.println(timeStr.replaceAll("(\\d{4})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{2})(\\d{3})","$1年$2月$3日$4点$5分$6秒"));
    }
    
}