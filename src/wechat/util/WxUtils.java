package wechat.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import org.dom4j.io.SAXReader;

/**
 * 
 * @Description: 主要是解析xml文件和将java文件组装成xml
 * @Author lip
 * @Date 2016年7月20日 下午2:14:42
 */

public class WxUtils {

    public Map<String, String> parseXml() {

        try {
            InputStream input = new FileInputStream("");
            SAXReader reader = new SAXReader(); 
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }

}
