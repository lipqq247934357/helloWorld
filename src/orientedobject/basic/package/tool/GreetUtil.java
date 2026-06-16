package orientedobject.basic.pkgdemo.tool;

/**
 * 自定义工具类，放在 orientedobject.basic.pkgdemo.tool 包下
 */
public class GreetUtil {

    public static String greet(String name) {
        return "你好，" + name;
    }

    public static void printGreet(String name) {
        System.out.println(greet(name));
    }
}
