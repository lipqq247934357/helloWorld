package app.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * TCP 客户端演示
 *
 * 使用 Socket 连接到指定服务器，发送消息并读取服务器返回的数据。
 *
 * 运行方式：先启动 TcpServerDemo，再在同一台机器启动本类。
 */
public class TcpClientDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        String host = "localhost";
        int port = 9999;

        try (Socket socket = new Socket(host, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

            System.out.println("已连接到服务器：" + host + ":" + port);

            String[] messages = {"你好", "Java 网络编程", "bye"};
            for (String message : messages) {
                out.println(message);
                System.out.println("发送：" + message);

                String response = in.readLine();
                System.out.println("收到：" + response);
                Thread.sleep(200);
            }
        }
    }
}
