package Util;

import java.io.File;

import JavaSimple.javaBasic.FileOperation.FileOperation;

public class FileOp4TT {

    public static String touchAct = "C:\\Users\\lijunjie\\git\\twotiger_customer\\WebContent\\resource\\touch\\img\\act";
    public static String pcAct = "C:\\Users\\lijunjie\\git\\twotiger_customer\\WebContent\\resource\\web\\img\\act";
    public static String desktop = "C:\\Users\\lijunjie\\Desktop\\";
    public static FileOperation fileOp = new FileOperation();

    public static void main(String[] args) {

        /**
         * 思路：主要是通过来源位置
         */

        String source = "";
        //返回文件
        File f = fileOp.ReadDir(sourcePath(source), "img");
        //TODO 将文件夹里面的文件放入指定目录
        
        //返回html文件
        File f2 = fileOp.ReadDir(sourcePath(source), ".html");
        //TODO 将html文件进行处理
        String str = dealFile(f2);
        //TODO 将内容放入指定的文件
        fileOp.WriteFile(str);
        //TODO 复制js文件，pc和touch的
        fileOp.copyFile(resource,end);
        //TODO 生成符合规范的config配置信息
        createConfigInfo();
    }

    public static String sourcePath(String source) {
        return desktop + source;
    }
    /**
     * 思路：逐步进行处理
     * 
     * 主要思路1.先将文件不进行处理直接放入指定的目录中的指定位置
     * 
     * 二次优化:将文件的描述信息和默认的js增加上
     * 
     * 三次优化：将文件的img换成正确的img
     * 
     * 四次优化：提取指定内容，执行上面优化，放入指定文件中
     * 
     * @param f2
     * @return
     */
    private static String dealFile(File f2) {
        return null;
    }

    private static void createConfigInfo() {
        // TODO Auto-generated method stub
        
    }
}
