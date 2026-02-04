package io;

import java.io.File;
import java.util.Scanner;

public class Demo3 {
    public static void main(String[] args) {
        File file = new File("text.md");

        //对文件进行删除
        System.out.println(file.delete());
        file.deleteOnExit();

        Scanner sc = new Scanner(System.in);
        System.out.println("输入任意键结束");
        sc.nextLine();

    }
}
