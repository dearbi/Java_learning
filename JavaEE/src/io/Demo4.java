package io;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo4 {
    public static void main(String[] args) {
        File file =new File("./");

        //通过list方法获取当前目录下的所有文件
        String[] list = file.list();
        assert list != null;
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(Arrays.toString(list));

        File[] files = file.listFiles();
        System.out.println(Arrays.toString(files));
    }
}
