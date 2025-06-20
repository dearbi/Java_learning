import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int d = cin.nextInt();
        int m = cin.nextInt();
        int y = cin.nextInt();
        boolean vaild = true;
        if (d > 31 || d < 1 || m < 1 || m > 12) {
            vaild = false;
        } else {
            if (m == 4 || m == 6 || m == 9 || m == 11) {
                if (d > 30) {
                    vaild = false;
                }
            }
            if (m == 2) {
                if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
                    if (d > 29) {
                        vaild = false;
                    }
                } else {
                    if (d > 28) {
                        vaild = false;
                    }
                }
            }
        }
        if (vaild) {
            System.out.println("valid date");
        } else {
            System.out.println("invalid date");
        }
    }
}