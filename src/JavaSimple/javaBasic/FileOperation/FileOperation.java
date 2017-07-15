package JavaSimple.javaBasic.FileOperation;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperation {

    /**
     * 读文件指的是对一个指定的文件进行操作，然后返回操作之后的数据作为原料
     * 
     * @throws IOException
     */
    public static void ReadFile(File f) throws IOException {

        FileReader fr = new FileReader(f);
        //定义个char类型的数组。
        char[] buf = new char[1024];
        int len = 0;
        while ((len = fr.read(buf)) != -1) {
            System.out.println(new String(buf, 0, len));
        }
        fr.close();
    }

    /**
     * 读文件指的是读取某个目录下的文件或者文件夹
     * 
     * @param path
     * @param name
     * @return
     */
    public static File ReadDir(String path, String name) {
        File file = new File(path);
        File[] tempList = file.listFiles();

        //如果目录中，包含'.'，就说明是文件，否则是文件夹
        boolean type = name.contains(".");
        for (int i = 0; i < tempList.length; i++) {
            if (type) {
                if (tempList[i].isFile()) {
                    //System.out.println("文     件："+tempList[i].getName());
                    if (tempList[i].getName().contains(name)) {
                        return tempList[i];
                    }
                }
            } else {
                if (tempList[i].isDirectory()) {
                    //System.out.println("文件夹：" + tempList[i].getName());
                    if (tempList[i].getName().equals(name)) {
                        return tempList[i];
                    }
                }
            }
        }
        return null;
    }

    /**
     * 写文件夹指的是将某个文件夹下的内容放到某个目录中
     * 
     * @param des
     * @param f
     */
    public static void WriteDir(String des, File f) {

    }

    /**
     * 写文件指的是将数据进行一系列操作之后放到某个文件中
     * 
     * @throws IOException
     */
    public static void WriteFile() throws IOException {

        FileWriter fw = new FileWriter("C:\\Users\\lijunjie\\Desktop\\我能理财推广");
        fw.write("abcd");
        fw.flush();
        fw.close();
    }
}
