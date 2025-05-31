import java.util.Random;
import java.util.Scanner;


public class 输出输出 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt())
        {
            int n = scanner.nextInt();
            System.out.println(n);
        }
    }
    //    public static void main(String[] args) {
    //        //生成随机数字
    //        Random random = new Random(100);//[0,100)
    //        Scanner input = new Scanner(System.in);
    //        int num = random.nextInt();
    //    }
}
