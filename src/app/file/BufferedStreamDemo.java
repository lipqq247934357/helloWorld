package app.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 缓冲流 BufferedInputStream / BufferedOutputStream / BufferedReader / BufferedWriter 演示
 *
 * 缓冲流在内部维护一个缓冲区，可以减少系统 IO 调用次数，显著提高读写效率。
 * 实际开发中，通常使用缓冲流包装底层的文件流。
 */
public class BufferedStreamDemo {

    public static void main(String[] args) throws IOException {
        String basePath = "/Users/lipeng/Desktop/myProject/helloWorld/out/file_demo_temp/buffered_stream";
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 1. 使用 BufferedWriter / BufferedReader 按行读写文本
        File textFile = new File(dir, "buffered.txt");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(textFile))) {
            for (int i = 1; i <= 5; i++) {
                bw.write("第 " + i + " 行内容");
                bw.newLine(); // 自动写入换行符，跨平台
            }
        }

        System.out.println("按行读取文本文件：");
        try (BufferedReader br = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("  " + line);
            }
        }

        // 2. 使用 BufferedInputStream / BufferedOutputStream 复制大文件并对比耗时
        File source = new File(dir, "big.bin");
        File target = new File(dir, "big_copy.bin");
        byte[] data = new byte[1024 * 1024]; // 1 MB
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte) (i % 256);
        }
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(source))) {
            bos.write(data);
        }

        long start = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(target))) {
            byte[] buffer = new byte[4096];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("\n使用缓冲流复制 1MB 文件耗时：" + (end - start) + " ms");
        System.out.println("源文件大小：" + source.length() + " 字节");
        System.out.println("目标文件大小：" + target.length() + " 字节");
    }
}
