package app.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Java NIO.2 Files / Path 工具类演示
 *
 * Java 7 引入的 NIO.2 提供了更现代、更简洁的文件操作 API，
 * 包括一次性读写、复制、移动、遍历目录树等。
 */
public class NioFilesDemo {

    public static void main(String[] args) throws IOException {
        Path base = Paths.get("/Users/lipeng/Desktop/myProject/helloWorld/out/file_demo_temp/nio_files");

        // 创建目录
        Files.createDirectories(base);

        // 写入多行文本
        Path file = base.resolve("nio.txt");
        List<String> lines = Arrays.asList("第一行", "第二行", "第三行");
        Files.write(file, lines, StandardCharsets.UTF_8);
        System.out.println("已写入文件：" + file);

        // 读取所有行
        List<String> readLines = Files.readAllLines(file, StandardCharsets.UTF_8);
        System.out.println("\n文件内容：");
        readLines.forEach(line -> System.out.println("  " + line));

        // 复制文件
        Path copy = base.resolve("nio_copy.txt");
        Files.copy(file, copy, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("\n已复制到：" + copy);

        // 创建子目录及文件
        Path subDir = base.resolve("sub");
        Files.createDirectories(subDir);
        Files.write(subDir.resolve("a.txt"), "a".getBytes(StandardCharsets.UTF_8));
        Files.write(subDir.resolve("b.txt"), "b".getBytes(StandardCharsets.UTF_8));

        // 遍历目录树
        System.out.println("\n目录树：");
        try (Stream<Path> walk = Files.walk(base)) {
            walk.forEach(p -> System.out.println("  " + p));
        }

        // 常用属性
        System.out.println("\n文件大小：" + Files.size(file) + " 字节");
        System.out.println("是否可读：" + Files.isReadable(file));
        System.out.println("是否可写：" + Files.isWritable(file));
        System.out.println("最后修改时间：" + Files.getLastModifiedTime(file));

        // 清理
        Files.deleteIfExists(copy);
    }
}
