package io;

import java.io.*;

public class Demo8_推荐写法 {
    public static void main(String[] args) throws IOException {
//        while(true) {
//            int data = inputStream.read();
//            if(data==-1) {
//                break;
//            }
//            System.out.printf("0x%x\n",data);
//        }
        try(InputStream inputStream = new FileInputStream("./1.txt")){
            //通过read读取数据，一次读一个字节数组
            while(true){
                byte[] b = new byte[1024];
                //read方法会尽可能把参数的数据填满
                int n=inputStream.read(b);
                if(n==-1){
                    break;
                }
                for(int i=0;i<n;i++){
                    System.out.printf("0x%X\n",b[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
