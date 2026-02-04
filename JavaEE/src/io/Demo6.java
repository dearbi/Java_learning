package io;

import java.io.File;
import java.io.IOException;

public class Demo6 {
    public static void main(String[] args) {
        File fileSrc = new File("text.md");
        if (!fileSrc.exists()) {
            //创建
            try {
                fileSrc.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //重命名
        File fileDest = new File("text2.md");
        System.out.println(fileSrc.renameTo(fileDest));


    }
}
