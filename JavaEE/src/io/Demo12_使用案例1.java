package io;

import java.io.File;
import java.util.Scanner;

public class Demo12_使用案例1 {
    public static void main(String[] args) {
        //1.让用户通过控制台输入路径和指定字符串
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件路径：");
        String basePath = scanner.nextLine();
        System.out.println("请输入指定字符串：");
        String word = scanner.nextLine();

        //2. 需要对用户的输入进行验证
        File file = new File(basePath);
        if(!file.isDirectory()){
            System.out.println("文件路径不存在!");
            return;
        }
        if(word.isEmpty()){
            System.out.println("指定字符串不能为空");
            return;
        }

        //3. 单独创建一个方法，实现递归遍历
        searchFile(file,word);
    }

    private static void searchFile(File baseFile, String word) {
        //1. 列出baseFile 下的所有文件
        File[] files = baseFile.listFiles();
        if(files == null){
            return;
        }
        //2. 遍历files数组，判断每个元素是文件还是目录
        for(File file : files){
            System.out.println("当前搜索文件："+file.getName()+file.getAbsolutePath());
            if(file.isFile()){
                //针对文件名判定
                dealFile(file,word);
            }else if(file.isDirectory()){
                //递归遍历目录
                searchFile(file,word);
            }
        }
    }

    private static void dealFile(File file, String word) {
        if(file.getName().contains(word)){
            //提示用户，是否删除
            System.out.println("是否删除文件：" + file.getAbsolutePath() + "？(y/n)");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            if(choice.equalsIgnoreCase("y")){
                file.delete();
                System.out.println("文件删除成功！");
            }else {
                System.out.println("文件未删除！");
            }
        }
    }

}
