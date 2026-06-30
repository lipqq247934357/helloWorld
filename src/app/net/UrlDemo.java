package app.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * URL / URLConnection 演示
 *
 * URL 用于统一资源定位，可解析协议、主机、端口、路径、查询参数等信息；
 * URLConnection 用于打开与远程资源的连接并读取内容。
 */
public class UrlDemo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.example.com/index.html?name=java&version=17");

        System.out.println("协议（protocol）：" + url.getProtocol());
        System.out.println("主机（host）：" + url.getHost());
        System.out.println("端口（port）：" + url.getPort());
        System.out.println("默认端口（defaultPort）：" + url.getDefaultPort());
        System.out.println("路径（path）：" + url.getPath());
        System.out.println("查询参数（query）：" + url.getQuery());
        System.out.println("文件（file）：" + url.getFile());

        // 读取网页内容
        System.out.println("\n尝试读取首页内容（前 200 字符）：");
        try {
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null && sb.length() < 200) {
                    sb.append(line).append("\n");
                }
                System.out.println(sb);
            }
        } catch (Exception e) {
            System.out.println("读取失败（可能没有网络）："
                    + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
