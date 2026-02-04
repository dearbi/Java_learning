package io;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Demo10_字符流 {
    public static void main(String[] args) {
        try(Reader reader = new FileReader("./1.txt")){

            //使用read方法读取数据
//            while(true){
//                int data = reader.read();
//                if(data==-1){
//                    break;
//                }
//                System.out.println((char)data);
//            }

            while(true){
                char[] c = new char[1024];
                int n = reader.read(c);
                if(n==-1){
                    break;
                }
                for(int i=0;i<n;i++){
                    System.out.print(c[i]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
