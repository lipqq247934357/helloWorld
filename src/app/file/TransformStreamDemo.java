package app.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

/**
 * 转换流 InputStreamReader / OutputStreamWriter 演示
 *
 * 转换流是字节流与字符流之间的桥梁，可以指定字符编码，
 * 解决 FileReader/FileWriter 使用系统默认编码可能导致的乱码问题。
 */
public class TransformStreamDemo {

    public static void main(String[] args) throws IOException {
        String basePath = "/Users/lipeng/Desktop/myProject/helloWorld/out/file_demo_temp/transform_stream";
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File utf8File = new File(dir, "utf8.txt");
        File gbkFile = new File(dir, "gbk.txt");
        String content = "Java IO 编码转换：你好，世界！";

        // 使用 UTF-8 编码写入
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(utf8File), "UTF-8")) {
            writer.write(content);
        }

        // 使用 GBK 编码写入
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(gbkFile), "GBK")) {
            writer.write(content);
        }

        System.out.println("UTF-8 文件大小：" + utf8File.length() + " 字节");
        System.out.println("GBK 文件大小：" + gbkFile.length() + " 字节");

        // 按 GBK 读取 GBK 文件
        try (Reader reader = new InputStreamReader(new FileInputStream(gbkFile), "GBK")) {
            char[] buffer = new char[128];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, len);
            }
            System.out.println("按 GBK 读取：" + sb);
        }

        // 按 UTF-8 读取 UTF-8 文件
        try (Reader reader = new InputStreamReader(new FileInputStream(utf8File), "UTF-8")) {
            char[] buffer = new char[128];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, len);
            }
            System.out.println("按 UTF-8 读取：" + sb);
        }
    }
}
