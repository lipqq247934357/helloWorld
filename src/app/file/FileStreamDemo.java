package app.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 字节流 FileInputStream / FileOutputStream 演示
 *
 * 字节流以字节为单位读写数据，适合处理图片、音频、视频、可执行文件等二进制数据，
 * 也适合处理任何文本文件，但需要手动处理字符编码。
 */
public class FileStreamDemo {

    public static void main(String[] args) throws IOException {
        String basePath = "/Users/lipeng/Desktop/myProject/helloWorld/out/file_demo_temp/file_stream";
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File source = new File(dir, "source.txt");
        File target = new File(dir, "copy.txt");

        // 1. 使用 FileOutputStream 写入字节数据
        String content = "Hello Java IO\n你好，世界！";
        try (OutputStream out = new FileOutputStream(source)) {
            out.write(content.getBytes("UTF-8"));
            System.out.println("已写入源文件：" + source.getAbsolutePath());
        }

        // 2. 使用 FileInputStream + FileOutputStream 复制文件
        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(target)) {
            byte[] buffer = new byte[8];
            int len;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer, 0, len);
            }
            System.out.println("已复制到目标文件：" + target.getAbsolutePath());
        }

        // 3. 读取目标文件内容并打印
        try (InputStream in = new FileInputStream(target)) {
            byte[] buffer = new byte[1024];
            int len = in.read(buffer);
            String readContent = new String(buffer, 0, len, "UTF-8");
            System.out.println("\n复制后文件内容：");
            System.out.println(readContent);
        }

        System.out.println("源文件大小：" + source.length() + " 字节");
        System.out.println("目标文件大小：" + target.length() + " 字节");
    }
}
