package ActOptimize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileCopy {

    /**
     * 将输入目录中的内容拷贝到输出目录
     *      input的默认其实目录是桌面
     * @param input
     * @param output
     * @param type
     */

    public void transfer(String input, String output, int type) {
        //output默认是web端的或者touch端的入口

        String resource = "C:\\Users\\TigerYoung1\\Desktop\\" + input;
        String destination = output;
        if (output.equals("output")) {//说明是默认路径
            if (type == 1) {//web端
                destination = "";
            } else {//touch端
                destination = "";
            }
        }
       //将resource下面的所有文件和文件夹拷贝到destination目录下
        
        


    }
    
    //将某个目录下的文件拷贝到另外一个目录
    
    
    /** 
      * 复制整个文件夹内容 
      * @param oldPath String 原文件路径 如：c:/fqf 
      * @param newPath String 复制后路径 如：f:/fqf/ff 
      * @return boolean 
      */ 
    public void copyFolder(String oldPath, String newPath) { 
        try { 
            (new File(newPath)).mkdirs(); //如果文件夹不存在 则建立新文件夹 
            File a=new File(oldPath); 
            String[] file=a.list(); 
            File temp=null; 
            for (int i = 0; i < file.length; i++) { 
                if(oldPath.endsWith(File.separator)){ 
                    temp=new File(oldPath+file[i]); 
                } 
                else{ 
                    temp=new File(oldPath+File.separator+file[i]); 
                } 
                if(temp.isFile()){ 
                    FileInputStream input = new FileInputStream(temp); 
                    FileOutputStream output = new FileOutputStream(newPath + "/" + 
                            (temp.getName()).toString()); 
                    byte[] b = new byte[1024 * 5]; 
                    int len; 
                    while ( (len = input.read(b)) != -1) { 
                        output.write(b, 0, len); 
                    } 
                    output.flush(); 
                    output.close(); 
                    input.close(); 
                } 
                if(temp.isDirectory()){//如果是子文件夹 
                    copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]); 
                } 
            } 
        } 
        catch (Exception e) { 
            System.out.println("复制整个文件夹内容操作出错"); 
            e.printStackTrace(); 
        } 
    }
    
}
