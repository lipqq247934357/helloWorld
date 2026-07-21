package utils;

import java.io.File;

public class FindNodeModule {

    public static String Dir1 = "/Users/lipeng/Desktop/myProject";
    public static String Dir2 = "/Users/lipeng/Desktop/project";

    public static String findNodeModule(String path) {
        File rootDir = new File(path);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            return "路径不存在或不是目录: " + path;
        }

        File[] projects = rootDir.listFiles(File::isDirectory);
        if (projects == null || projects.length ==0) {
            return "目录下没有子项目: " + path;
        }

        StringBuilder result = new StringBuilder();
        result.append("扫描目录: ").append(rootDir.getAbsolutePath()).append("\n");

        boolean found = false;
        for (File project : projects) {
            File nodeModules = new File(project, "node_modules");
            if (nodeModules.exists() && nodeModules.isDirectory()) {
                found = true;
                result.append("✓ ").append(project.getName())
                        .append(" (").append(project.getAbsolutePath()).append(")\n");
            }
        }

        if (!found) {
            result.append("未发现任何项目包含 node_modules\n");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(findNodeModule(Dir2));
    }

}