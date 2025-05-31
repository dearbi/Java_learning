import java.util.Scanner;

public class Main {
    public static boolean juage(String s){
        if(s.length()<6||s.length()>10){
            return false;
        }

        boolean hasDigit=false;
        boolean hasUpper=false;
        boolean hasLower = false;
        boolean hasSpecial=false;

        for(char c:s.toCharArray()){
            if(Character.isWhitespace(c))
                return false;
            else if(Character.isDigit(c))
                hasDigit = true;
            else if(Character.isUpperCase(c))
                hasUpper=true;
            else if(Character.isLowerCase(c))
                hasLower = true;
            else
                hasSpecial=true;
        }
        return hasDigit&&hasUpper&&hasLower&&hasSpecial;
    }
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        String s=cin.nextLine();
        boolean valid=juage(s);
        System.out.println(valid ? "Password is valid" : "Password is invalid");
    }
}
