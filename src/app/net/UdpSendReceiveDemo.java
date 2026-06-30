package app.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP 发送与接收演示
 *
 * UDP 是无连接、不可靠的传输协议，适合对实时性要求高、可容忍少量丢包的场景。
 * 本 demo 在同一程序中启动接收端线程和发送端，完成一次双向 UDP 通信。
 */
public class UdpSendReceiveDemo {

    public static void main(String[] args) throws Exception {
        int port = 9876;

        Thread receiver = new Thread(() -> {
            try (DatagramSocket socket = new DatagramSocket(port)) {
                System.out.println("UDP 接收端启动，端口：" + port);

                byte[] buffer = new byte[1024];
                for (int i = 0; i < 3; i++) {
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                    socket.receive(packet);

                    String received = new String(packet.getData(), 0, packet.getLength());
                    System.out.println("接收端收到：" + received);

                    String reply = "已收到：" + received;
                    byte[] replyBytes = reply.getBytes();
                    DatagramPacket replyPacket = new DatagramPacket(
                            replyBytes, replyBytes.length,
                            packet.getAddress(), packet.getPort());
                    socket.send(replyPacket);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        receiver.start();
        Thread.sleep(300);

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName("localhost");

            for (int i = 1; i <= 3; i++) {
                String message = "UDP 消息 " + i;
                byte[] data = message.getBytes();
                DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
                socket.send(packet);
                System.out.println("发送端发送：" + message);

                byte[] buffer = new byte[1024];
                DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                socket.receive(reply);
                System.out.println("发送端收到：" + new String(reply.getData(), 0, reply.getLength()));

                Thread.sleep(200);
            }
        }

        receiver.join(5000);
        System.out.println("UDP 演示结束");
    }
}
