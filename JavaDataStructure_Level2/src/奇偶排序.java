import java.util.Arrays;
import java.util.Scanner;

public class 奇偶排序 {
public static void main(String[] args) {
	Scanner cin=new Scanner(System.in);
	int n=cin.nextInt();
	Integer[] a= new Integer[n];
	for(int i=0;i<n;i++) {
		a[i]=cin.nextInt();
	}
	
	Arrays.sort(a,(o1,o2)->{
		if(o1%2==0&&o2%2!=0) {
			return 1;
		}
		if(o1%2!=0&&o2%2==0) {
			return -1;
		}
		return o1-o2;
	});
	for(int i=0;i<a.length;i++) {
		System.out.print(a[i]);
		if(i!=a.length-1) System.out.print(" ");
	}
	
}
}
