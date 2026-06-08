import utils.GitPushUtil;

public class Main {
    public static void main(String[] args) {
        try {
            GitPushUtil.push();
        } catch (Exception e) {
            System.err.println("推送失败: " + e.getMessage());
        }
    }
}
