package orientedobject.basic.pkgdemo;

// 方式1：导入某个类，之后可以直接用类名
import orientedobject.basic.pkgdemo.tool.GreetUtil;

// 方式2：不 import，调用时写全限定类名（下面 demonstrateFullName 用到）

/**
 * package 与 import 示例
 *
 * 源码放在 orientedobject/basic/package 目录下，但包名用 pkgdemo，
 * 因为 package 是 Java 保留字，不能写成 package orientedobject.basic.package;
 */
public class PackageImportDemo {

    public static void main(String[] args) {
        // 通过 import 后，直接使用 GreetUtil
        GreetUtil.printGreet("张三");
        System.out.println(GreetUtil.greet("李四"));

        demonstrateFullName("王五");
    }

    /** 不 import，使用全限定类名调用 */
    static void demonstrateFullName(String name) {
        orientedobject.basic.pkgdemo.tool.GreetUtil.printGreet(name);
    }
}
