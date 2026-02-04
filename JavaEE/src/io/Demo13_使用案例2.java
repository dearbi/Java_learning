package io;

import java.io.*;
import java.util.Scanner;

public class Demo13_使用案例2 {
    public static void main(String[] args) throws IOException {
        //1. 先让用户输入要复制的源文件的路径
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要复制的源文件的路径：");
        String srcPath = scanner.nextLine();
        //让用户输入要复制的目标文件的路径
        System.out.println("请输入要复制的目标文件的路径：");
        String destPath = scanner.nextLine();
        //2. 对这两个路径判定是否合法
        //2.1 先判断源文件路径是否存在
        File srcFile = new File(srcPath);
        if(!srcFile.exists()){
            System.out.println("源文件路径不存在！");
            return;
        }
        //2.2 再判断目标文件路径是否存在
        File destFile = new File(destPath);
        File destParentFile = destFile.getParentFile();//获取目标文件的父目录
        if(!destParentFile.exists()){//如果父目录不存在
            System.out.println("目标文件所在的目录不存在！");
            return;
        }
        if(!destFile.exists()){
            destFile.createNewFile();
        }

        //3. 复制文件
        try(InputStream inputStream = new FileInputStream(srcFile);
            OutputStream outputStream = new FileOutputStream(destFile)){
            while(true){
                //读取文件操作
                byte[] bytes =new byte[1024];
                int len = inputStream.read(bytes);
                if(len == -1){
                    break;
                }
                //写入文件操作
                outputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
