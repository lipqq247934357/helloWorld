package app.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP 服务器端演示
 *
 * 使用 ServerSocket 监听指定端口，接受客户端连接后通过 Socket 进行双向通信。
 * 收到 "bye" 时向客户端发送告别语并关闭连接。
 *
 * 运行方式：先启动 TcpServerDemo，再启动 TcpClientDemo。
 */
public class TcpServerDemo {

    public static void main(String[] args) throws IOException {
        int port = 9999;

        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("TCP 服务器已启动，监听端口：" + port);
            System.out.println("等待客户端连接...");

            try (Socket socket = server.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

                System.out.println("客户端已连接：" + socket.getInetAddress().getHostAddress());

                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println("收到客户端消息：" + line);

                    if ("bye".equalsIgnoreCase(line)) {
                        out.println("再见！");
                        break;
                    }
                    out.println("服务器回声：" + line);
                }
            }

            System.out.println("服务器关闭连接");
        }
    }
}
