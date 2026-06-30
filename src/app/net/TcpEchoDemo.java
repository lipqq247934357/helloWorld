package app.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

/**
 * TCP 端到端回声演示
 *
 * 在一个程序中同时启动服务器线程和客户端：
 * 服务器使用动态端口（ServerSocket(0)），客户端自动连接该端口。
 * 适合直接运行观察一次完整的 TCP 通信过程。
 */
public class TcpEchoDemo {

    public static void main(String[] args) throws Exception {
        CountDownLatch readyLatch = new CountDownLatch(1);
        int[] actualPort = new int[1];

        Thread serverThread = new Thread(() -> {
            try (ServerSocket server = new ServerSocket(0)) {
                actualPort[0] = server.getLocalPort();
                System.out.println("内部 TCP 服务器启动，端口：" + actualPort[0]);
                readyLatch.countDown();

                try (Socket socket = server.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

                    String line;
                    while ((line = in.readLine()) != null) {
                        if ("bye".equalsIgnoreCase(line)) {
                            out.println("再见！");
                            break;
                        }
                        out.println("回声：" + line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        serverThread.start();
        readyLatch.await();
        Thread.sleep(300); // 等待服务器完全进入 accept 状态

        try (Socket socket = new Socket("localhost", actualPort[0]);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

            String[] messages = {"Hello", "Java TCP", "bye"};
            for (String message : messages) {
                out.println(message);
                System.out.println("客户端发送：" + message);
                System.out.println("客户端收到：" + in.readLine());
            }
        }

        serverThread.join(5000);
        System.out.println("TCP 演示结束");
    }
}
