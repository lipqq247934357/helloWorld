package app.exception;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * try-with-resources 自动资源关闭演示
 *
 * Java 7 引入的语法，用于自动关闭实现了 AutoCloseable 接口的资源。
 * 资源会在 try 代码块结束时自动关闭，即使在 try 块中发生异常也会关闭。
 */
public class ExceptionTryWithResourcesDemo {

    /**
     * 自定义一个实现了 AutoCloseable 的资源，用于观察关闭时机
     */
    static class DemoResource implements AutoCloseable {
        private final String name;

        public DemoResource(String name) {
            this.name = name;
            System.out.println("资源 " + name + " 已打开");
        }

        public void doSomething() {
            System.out.println("资源 " + name + " 正在工作");
        }

        @Override
        public void close() {
            System.out.println("资源 " + name + " 已自动关闭");
        }
    }

    public static void main(String[] args) {
        System.out.println("===== 1. 传统 try-finally 关闭资源 =====");
        InputStream input = null;
        try {
            input = new ByteArrayInputStream("hello".getBytes());
            byte[] buffer = new byte[1024];
            int len = input.read(buffer);
            System.out.println("读取到 " + len + " 个字节");
        } catch (IOException e) {
            System.out.println("读取失败：" + e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                    System.out.println("传统方式：资源已关闭");
                } catch (IOException e) {
                    System.out.println("关闭资源失败：" + e.getMessage());
                }
            }
        }

        System.out.println("\n===== 2. try-with-resources 自动关闭资源 =====");
        try (InputStream input2 = new ByteArrayInputStream("world".getBytes())) {
            byte[] buffer = new byte[1024];
            int len = input2.read(buffer);
            System.out.println("读取到 " + len + " 个字节");
        } catch (IOException e) {
            System.out.println("读取失败：" + e.getMessage());
        }

        System.out.println("\n===== 3. 管理多个资源 =====");
        try (DemoResource resource1 = new DemoResource("A");
             DemoResource resource2 = new DemoResource("B")) {
            resource1.doSomething();
            resource2.doSomething();
        }

        System.out.println("\n程序正常结束");
    }
}
