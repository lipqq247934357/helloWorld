
# 文件与 IO 流

## IO 流概述

Java 中的 IO（Input/Output）流用于在程序与外部设备（文件、网络、内存等）之间传输数据。
按照传输单位可分为：

- **字节流**：以字节（byte）为单位，适合处理所有类型文件，如图片、音频、视频等二进制数据。
- **字符流**：以字符（char）为单位，适合处理文本文件，内部会自动处理字符编码。

按照流向可分为：

- **输入流**：将外部数据读入程序（InputStream / Reader）。
- **输出流**：将程序数据写出到外部（OutputStream / Writer）。

## 常用流分类

| 类型 | 字节流 | 字符流 |
| --- | --- | --- |
| 基础流 | FileInputStream / FileOutputStream | FileReader / FileWriter |
| 缓冲流 | BufferedInputStream / BufferedOutputStream | BufferedReader / BufferedWriter |
| 转换流 | InputStreamReader / OutputStreamWriter | - |
| 数据流 | DataInputStream / DataOutputStream | - |
| 对象流 | ObjectInputStream / ObjectOutputStream | - |
| 打印流 | PrintStream / PrintWriter | - |
| 随机访问 | RandomAccessFile | - |

## 本目录 demo 文件说明

| 文件名 | 说明 |
| --- | --- |
| FileBasicDemo.java | File 类常用操作：创建、删除、重命名、属性查询、列出目录 |
| FileStreamDemo.java | 字节流 FileInputStream / FileOutputStream 读写与复制 |
| FileReaderWriterDemo.java | 字符流 FileReader / FileWriter 读写文本 |
| BufferedStreamDemo.java | 缓冲流 BufferedReader / BufferedWriter、BufferedInputStream / BufferedOutputStream |
| TransformStreamDemo.java | 转换流 InputStreamReader / OutputStreamWriter 指定编码读写 |
| DataStreamDemo.java | 数据流 DataInputStream / DataOutputStream 读写基本类型 |
| User.java | ObjectStreamDemo 使用的可序列化实体类 |
| ObjectStreamDemo.java | 对象流 ObjectInputStream / ObjectOutputStream 序列化与反序列化 |
| RandomAccessFileDemo.java | RandomAccessFile 随机位置读写 |
| NioFilesDemo.java | Java NIO.2 中 Files / Path 工具类的现代文件操作 |
