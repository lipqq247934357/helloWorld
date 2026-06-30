package app.file;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 字符流 FileReader / FileWriter 演示
 *
 * 字符流以字符为单位读写数据，内部会自动处理字符编码，
 * 适合处理纯文本文件，如 .txt、.java、.xml 等。
 */
public class FileReaderWriterDemo {

    public static void main(String[] args) throws IOException {
        String basePath = "/Users/lipeng/Desktop/myProject/helloWorld/out/file_demo_temp/file_reader_writer";
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(dir, "poem.txt");

        // 使用 FileWriter 写入文本（第二个参数 true 表示追加模式）
        try (Writer writer = new FileWriter(file, true)) {
            writer.write("静夜思\n");
            writer.write("床前明月光，\n");
            writer.write("疑是地上霜。\n");
            writer.append("举头望明月，\n");
            writer.append("低头思故乡。\n");
            System.out.println("已写入文本文件：" + file.getAbsolutePath());
        }

        // 使用 FileReader 读取文本
        try (Reader reader = new FileReader(file)) {
            char[] buffer = new char[64];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = reader.read(buffer)) != -1) {
                sb.append(buffer, 0, len);
            }
            System.out.println("\n文件内容：");
            System.out.println(sb);
        }
    }
}
