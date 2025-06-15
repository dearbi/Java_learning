import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int t1 = cin.nextInt();
        if (t1 < 0 || t1 > 24) {
            System.out.println("Value for hours must be in the range 0 to 12");
            return;
        }
        int t2 = cin.nextInt();
        if (t2 < 0 || t2 > 59) {
            System.out.println("Value for minutes must be in the range 0 to 59");
            return;
        } else {
            int c = cin.nextInt();
            if (c == 1) {
                if (t1 > 12) {
                    t1 = t1 % 12;
                }
            } else {
                if (t1 == 0) {
                    t1 = 12;
                }
            }
            System.out.printf("%02d:%02d", t1, t2);
        }

    }
}