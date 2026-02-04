package io;

import java.io.File;

public class Demo5 {
    public static void main(String[] args) {
        File file =new File("./111");

        boolean b = file.mkdir();
        System.out.println(b);

        file.delete();
    }
}
