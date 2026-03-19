import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class 哈西表 {
	static Scanner cin=new Scanner(System.in);
public static void main(String[] args) {
	Set<Integer> set=new HashSet<>();
	
	int n=cin.nextInt();
	cin.nextLine();

	for(int i=0;i<n;i++) {
		String s=cin.nextLine();
		String[] parts=s.split(" ");
		
		String op=parts[0];
		int x=Integer.parseInt(parts[1]);

		if(op.equals("I")) {
			set.add(x);
		}else if(op.equals("Q")) {
			System.out.println(set.contains(x)?"Yes":"No");
		}
	}
	cin.close();
}
}
