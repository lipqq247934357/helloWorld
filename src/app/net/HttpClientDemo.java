package app.net;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 * Java 11 HttpClient 演示
 *
 * HttpClient 是 Java 11 引入的现代 HTTP 客户端，支持同步、异步、HTTP/2 等特性。
 * 本 demo 以同步 GET 请求为例，展示状态码、响应头和响应体的读取。
 */
public class HttpClientDemo {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://www.example.com"))
                .GET()
                .timeout(Duration.ofSeconds(5))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("状态码：" + response.statusCode());
            System.out.println("Content-Type："
                    + response.headers().firstValue("Content-Type").orElse("无"));

            String body = response.body();
            System.out.println("\n响应体前 200 字符：");
            System.out.println(body.length() > 200 ? body.substring(0, 200) : body);
        } catch (Exception e) {
            System.out.println("请求失败（可能没有网络）："
                    + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
    }
}
