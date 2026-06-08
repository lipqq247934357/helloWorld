import utils.GitPushUtil;

public class Main {

    public static String RepoName = "myProject/helloWorld";

    public static void main(String[] args) {
        // 推送 helloWorld 项目`
        push(Main.RepoName);
    }

    public static void push(String gitRepoName) {
        try {
            GitPushUtil.push(gitRepoName);
        } catch (Exception e) {
            System.err.println("推送失败: " + e.getMessage());
        }
    }
}
