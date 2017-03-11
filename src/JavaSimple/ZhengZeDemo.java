package JavaSimple;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * 
 * @Description: 正则表达式的使用和总结 
 * @Author 李鹏
 * @Date 2016年9月12日 上午11:42:56
 */


public class ZhengZeDemo {

    @Test
    public void demo1() {

        //Arrays.sort(); 数组排序采用这个方法 

    }

    //获取匹配内容
    @Test
    public void demo2() {

        Pattern p = Pattern.compile("hel*o lipeng!");
        //pattern:模板的意思，就是匹配的正则代码

        //p.mather() 匹配需要被匹配的字符串
        Matcher m = p.matcher("hello lipeng!");
        //match 匹配器，匹配的结果信息 
        
        
        if (m.matches()) {
            String str = m.replaceFirst("haha");
            System.out.println(m);
        } else {
            System.out.println("error!");
        }

    }

}
