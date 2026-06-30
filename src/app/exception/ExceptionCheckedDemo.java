package app.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 编译时异常（Checked Exception）与 throws 声明演示
 *
 * 编译时异常在编译阶段就必须处理，否则无法通过编译。
 * 处理方式有两种：
 * 1. 使用 try...catch...finally 在当前方法中捕获并处理
 * 2. 使用 throws 关键字声明抛出，交给上层调用者处理
 */
public class ExceptionCheckedDemo {

    /**
     * 声明方法可能抛出 FileNotFoundException
     */
    public static void readFile(String path) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        System.out.println("成功打开文件：" + path);
    }

    /**
     * 声明方法可能抛出多个编译时异常
     */
    public static void loadClass(String className) throws ClassNotFoundException, IllegalAccessException {
        Class<?> clazz = Class.forName(className);
        System.out.println("成功加载类：" + clazz.getName());
    }

    public static void main(String[] args) {
        System.out.println("===== 1. 调用方使用 try-catch 处理 throws 声明的异常 =====");
        try {
            // 传入一个不存在的文件路径，触发 FileNotFoundException
            readFile("/path/to/not/exist/file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("捕获到文件未找到异常：" + e.getMessage());
        }

        System.out.println("\n===== 2. main 方法继续向上抛出 =====");
        try {
            // loadClass 声明抛出 ClassNotFoundException，调用方必须处理
            loadClass("com.not.exist.DemoClass");
        } catch (ClassNotFoundException e) {
            System.out.println("捕获到类未找到异常：" + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("捕获到非法访问异常：" + e.getMessage());
        }

        System.out.println("\n===== 3. 多异常合并捕获（Java 7+） =====");
        try {
            readFile("/path/to/not/exist/file.txt");
            loadClass("com.not.exist.DemoClass");
        } catch (FileNotFoundException | ClassNotFoundException e) {
            System.out.println("合并捕获到异常：" + e.getClass().getSimpleName() + " - " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("捕获到非法访问异常：" + e.getMessage());
        }

        System.out.println("\n程序正常结束");
    }
}
