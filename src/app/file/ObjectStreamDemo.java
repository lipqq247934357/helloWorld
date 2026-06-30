package app.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 对象流 ObjectInputStream / ObjectOutputStream 演示
 *
 * 对象流可以将 Java 对象序列化后写入文件，或从文件中反序列化读取对象。
 * 被序列化的对象所属类必须实现 java.io.Serializable 接口。
 */
public class ObjectStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String basePath = "/Users/lipeng/Desktop/myProject/helloWorld/out/file_demo_temp/object_stream";
        File dir = new File(basePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(dir, "users.dat");

        // 构造对象列表
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Alice", 20));
        users.add(new User(2L, "Bob", 25));

        // 序列化：将对象写入文件
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(users);
            System.out.println("对象已序列化到：" + file.getAbsolutePath());
        }

        // 反序列化：从文件读取对象
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            @SuppressWarnings("unchecked")
            List<User> list = (List<User>) ois.readObject();
            System.out.println("反序列化后的对象：");
            for (User user : list) {
                System.out.println("  " + user);
            }
        }

        System.out.println("\n注意：User 的 age 字段被 transient 修饰，反序列化后 age 为默认值 0");
    }
}
