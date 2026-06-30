package app.file;

import java.io.File;
import java.io.IOException;

/**
 * File 类基础操作演示
 *
 * File 是 Java 中用于表示文件或目录路径名的抽象表示，
 * 可用于创建、删除、重命名、查询属性等，但本身不负责文件内容的读写。
 */
public class FileBasicDemo {

    public static void main(String[] args) throws IOException {
        String basePath = "/Users/lipeng/Desktop/myProject/helloWorld/out/file_demo_temp/file_basic";
        File dir = new File(basePath);

        // 创建多级目录
        if (!dir.exists()) {
            boolean mkdirs = dir.mkdirs();
            System.out.println("创建目录：" + mkdirs);
        }

        File file = new File(dir, "hello.txt");

        // 创建新文件
        if (!file.exists()) {
            boolean created = file.createNewFile();
            System.out.println("创建文件：" + created);
        }

        // 常用查询方法
        System.out.println("绝对路径：" + file.getAbsolutePath());
        System.out.println("规范路径：" + file.getCanonicalPath());
        System.out.println("文件名：" + file.getName());
        System.out.println("父目录：" + file.getParent());
        System.out.println("是否文件：" + file.isFile());
        System.out.println("是否目录：" + file.isDirectory());
        System.out.println("是否可读：" + file.canRead());
        System.out.println("是否可写：" + file.canWrite());
        System.out.println("文件大小：" + file.length() + " 字节");
        System.out.println("最后修改时间：" + file.lastModified());

        // 创建子目录并在目录中创建另一个文件
        File subDir = new File(dir, "subDir");
        subDir.mkdir();
        File childFile = new File(subDir, "child.txt");
        childFile.createNewFile();

        // 列出目录内容
        File[] children = dir.listFiles();
        System.out.println("\n目录 " + dir.getName() + " 下内容：");
        if (children != null) {
            for (File child : children) {
                String type = child.isDirectory() ? "[目录]" : "[文件]";
                System.out.println("  " + type + " " + child.getName());
            }
        }

        // 重命名文件
        File renamed = new File(dir, "hello_renamed.txt");
        boolean renameResult = file.renameTo(renamed);
        System.out.println("\n重命名结果：" + renameResult);

        // 清理资源
        System.out.println("删除重命名文件：" + renamed.delete());
        System.out.println("删除子文件：" + childFile.delete());
        System.out.println("删除子目录：" + subDir.delete());
        System.out.println("删除基础目录：" + dir.delete());
    }
}
