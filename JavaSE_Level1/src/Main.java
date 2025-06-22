import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String s = cin.nextLine();
        int n = s.length();
        if (s.charAt(n - 1) != 'y') {
            System.out.println("Cannot form the plural form with the rules given.");
        } else {
            if (s.charAt(n - 2) == 'u' || s.charAt(n - 3) == 'q') {
                System.out.print("soliloquy in plural form is: ");
                System.out.println(s.substring(0, n - 1) + "ies");
            } else if ("qeiou".indexOf(s.charAt(n - 2)) != -1) {
                System.out.print(s + " ");
                System.out.print("in plural form is: " + s + "s");
            }
        }
    }
}