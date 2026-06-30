package app.file;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 数据流 DataInputStream / DataOutputStream 演示
 *
 * 数据流可以按 Java 基本数据类型（int、double、boolean 等）读写数据，
 * 保持类型信息，方便后续按相同类型顺序读取。
 */
public class DataStreamDemo {

    public static void main(String[] args) throws IOException {
        String basePath = "/Users/lipeng/Desktop/myProject/helloWorld/out/file_demo_temp/data_stream";
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(dir, "data.bin");

        // 按类型写入数据
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            dos.writeInt(1024);
            dos.writeDouble(3.14159);
            dos.writeBoolean(true);
            dos.writeUTF("Java DataStream");
            dos.writeLong(123456789L);
        }

        // 按相同顺序、相同类型读取数据
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            System.out.println("int：" + dis.readInt());
            System.out.println("double：" + dis.readDouble());
            System.out.println("boolean：" + dis.readBoolean());
            System.out.println("UTF 字符串：" + dis.readUTF());
            System.out.println("long：" + dis.readLong());
        }
    }
}
