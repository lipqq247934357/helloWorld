import utils.GitPushUtil;
import chapter.chapter01.helloWorld;

public class Main {

    public static String RepoName = "myProject/helloWorld";
    public static String actionType = "pushGit";

    public static void main(String[] args) {

        switch (actionType) {
            case "helloWorld":
                // 调用 helloWorld 类中的 sayHello 方法
                helloWorld.sayHello(args);
                break;
            default:
                // 推送 helloWorld 项目`
                push(Main.RepoName);
                break;
        }

    }

    public static void push(String gitRepoName) {
        try {
            GitPushUtil.push(gitRepoName);
        } catch (Exception e) {
            System.err.println("推送失败: " + e.getMessage());
        }
    }
}
