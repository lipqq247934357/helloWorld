package app.file;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile 随机访问文件演示
 *
 * RandomAccessFile 支持在文件的任意位置读写，
 * 常用于需要频繁定位到指定位置的场景，如断点续传、数据库文件等。
 */
public class RandomAccessFileDemo {

    public static void main(String[] args) throws IOException {
        String basePath = "/Users/lipeng/Desktop/myProject/helloWorld/out/file_demo_temp/random_access";
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(dir, "data.txt");

        // "rw" 模式：可读可写
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            raf.writeUTF("Java");
            raf.writeInt(100);
            raf.writeDouble(99.5);
            System.out.println("写入完成，文件指针位置：" + raf.getFilePointer());
        }

        // "r" 模式：只读
        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
            raf.seek(0); // 将指针移动到文件开头
            System.out.println("读取 UTF：" + raf.readUTF());
            System.out.println("读取 int：" + raf.readInt());
            System.out.println("读取 double：" + raf.readDouble());
            System.out.println("读取完成后指针位置：" + raf.getFilePointer());
        }
    }
}
