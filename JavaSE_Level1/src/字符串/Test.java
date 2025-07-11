package 字符串;

import java.util.Locale;

public class Test {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abc").append("def");
        stringBuilder.append("hello");
        System.out.println(stringBuilder);
    }
    public static void main2(String[] args) {
        String str = "hello world hello bit" ;
        String[] result = str.split(" ",2) ; // 按照空格拆分
        for(String s: result) {
            System.out.println(s);
        }

    }
    public static void main1(String[] args) {
        String str = "abcdef";
        char ch = str.charAt(3);
        System.out.println(ch);
        char[] crr=str.toCharArray();
        for(char c : crr){
            System.out.print(c+" ");
        }

        int a = 123;
        String str2=String.valueOf(a);
        System.out.println(str2);
    }
}
