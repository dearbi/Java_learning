package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Demo9 {
    public static void main(String[] args) {
        //默认情况下，OutputStream打开文件就会清空文件内容
        //如果想追加内容，需要在构造方法中传入第二个参数true
        try(OutputStream outputStream = new FileOutputStream("./1.txt",true)){
//            outputStream.write(97);
//            outputStream.write(98);
//            outputStream.write(99);

            byte[] bytes = {91,92,93};
            outputStream.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
