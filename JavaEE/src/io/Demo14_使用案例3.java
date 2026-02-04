package io;

import java.io.*;
import java.util.Scanner;

public class Demo14_使用案例3 {
    public static void main(String[] args) {
        // 1. 输入要扫描的路径，以及要搜索的关键词
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径：");
        String path = scanner.nextLine();
        System.out.println("请输入要搜索的关键词：");
        String word = scanner.nextLine();

        //2. 对输入内容进行判断
        if(path.isEmpty() || word.isEmpty()){
            System.out.println("输入内容不能为空！");
            return;
        }
        File file = new File(path);
        if(!file.exists()){
            System.out.println("路径不存在！");
            return;
        }
        
        //3. 递归调用
        scanDir(file,word);
    }

    private static void scanDir(File file, String word) {
        File[] files = file.listFiles();
        if(files == null){
            return;
        }
        for(File f : files){
            System.out.println("当前搜索到文件"+f.getAbsolutePath());
            if(f.isFile()){
                dealFile(f,word);
            }else if(f.isDirectory()){
                scanDir(f,word);
            }
        }
    }

    private static void dealFile(File f, String word) {
        //先判定文件名是否包含
        if(f.getName().contains(word)){
            System.out.println("找到文件名匹配的结果："+f.getAbsolutePath());
            return;
        }
        //如果文件名不包含关键词，再判断文件内容是否包含关键词
        StringBuilder stringBuilder = new StringBuilder();
        try(Reader reader = new FileReader(f)){
            while(true){
                char[] chars = new char[1024];
                int len = reader.read(chars);
                if(len == -1){
                    break;
                }
                stringBuilder.append(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(stringBuilder.toString().contains(word)){
            System.out.println("找到文件内容匹配的结果："+f.getAbsolutePath());
        }
    }
}
