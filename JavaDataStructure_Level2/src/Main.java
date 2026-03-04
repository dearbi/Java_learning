import java.util.Arrays;
import java.util.Scanner;
public class Main {
	static Scanner cin=new Scanner(System.in);
	static final int N=(int)(5e5+10);
public static void main(String[] args) {
	int n=cin.nextInt();
	String[] a=new String[n];
	for(int i=0;i<n;i++){
		a[i]=cin.next();
	}
	Arrays.sort(a,(x,y)->{
		return (x+y).compareTo(y+x);
	});
	for(int i=0;i<n;i++){
		System.out.print(a[i]);
	}
	cin.close();
}
}
