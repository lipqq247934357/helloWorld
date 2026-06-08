package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GitPushUtil {

    private static final String DESKTOP_PATH = "/Users/lipeng/Desktop";

    public static String getRepoPath(String gitRepoName) {
        return DESKTOP_PATH + "/" + gitRepoName;
    }

    public static void push(String gitRepoName) throws Exception {
        String repoPath = getRepoPath(gitRepoName);

        System.out.println("cd " + repoPath);
        System.out.println("git push");

        Process process = new ProcessBuilder("git", "-C", repoPath, "push")
                .redirectErrorStream(true)
                .start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        if (process.waitFor() != 0) {
            throw new RuntimeException("git push 失败");
        }
    }
}
