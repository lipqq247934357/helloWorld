package app.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress 类基础演示
 *
 * InetAddress 用于表示 IP 地址，可通过主机名获取对应 IP，
 * 是 Java 网络编程中最基础的工具类之一。
 */
public class InetAddressDemo {

    public static void main(String[] args) {
        try {
            // 获取本机地址
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("本机主机名：" + localHost.getHostName());
            System.out.println("本机 IP 地址：" + localHost.getHostAddress());

            // 通过域名获取远程主机地址
            String host = "www.baidu.com";
            InetAddress remote = InetAddress.getByName(host);
            System.out.println("\n域名：" + host);
            System.out.println("主机名：" + remote.getHostName());
            System.out.println("IP 地址：" + remote.getHostAddress());

            // 获取域名的所有 IP 地址
            InetAddress[] allAddresses = InetAddress.getAllByName(host);
            System.out.println("\n该域名对应的所有 IP：");
            Arrays.stream(allAddresses)
                    .forEach(addr -> System.out.println("  " + addr.getHostAddress()));

        } catch (UnknownHostException e) {
            System.out.println("无法解析主机地址（可能没有网络）：" + e.getMessage());
        }
    }
}
