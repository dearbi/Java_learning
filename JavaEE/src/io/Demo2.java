package io;

import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) {
        File file = new File("text.md");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

        //创建一个空白的普通文件
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());

    }


}
