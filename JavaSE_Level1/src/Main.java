import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;
public class Main{
    public static void main(String[] args)throws IOException {
        Scanner sc= new Scanner(System.in);
        String ss=sc.nextLine();
        if(ss.isEmpty()){
            return ;
        }
        int pos=0;
        ArrayList<Character> c=new ArrayList<Character>();
        int dd=0;
        int al=0;
        int o=0;
        int[] asc=new int[150];
        for(int i=0;i<ss.length();i++){
            if(ss.charAt(i)=='1'||ss.charAt(i)=='2'||ss.charAt(i)=='3'||ss.charAt(i)=='4'||ss.charAt(i)=='5'||ss.charAt(i)=='6'||ss.charAt(i)=='7'||ss.charAt(i)=='8'||ss.charAt(i)=='9') {
                dd++;
            }else if((ss.charAt(i)<='z'&&ss.charAt(i)>='a')||(ss.charAt(i)>='A'&&ss.charAt(i)<='Z')){
                al++;
            }else{
                o++;
            }
            if(asc[ss.charAt(i)]==0){
                c.add(ss.charAt(i));
                asc[ss.charAt(i)]++;
            }else{
                asc[ss.charAt(i)]++;
            }
        }
        System.out.println("Frequency of each character type:");
        System.out.println("Digits: "+dd);
        System.out.println("Alphabetic Characters: "+al);
        System.out.println("Other Characters: "+o);
        System.out.println("");
        System.out.println("Frequency of each character is as follows:");
        for(int i=0;i<c.size();i++){
            Character t=c.get(i);
            t=Character.toLowerCase(t);
            System.out.println(t+" occurs "+asc[c.get(i)]+" time(s)");

        }
    }
}