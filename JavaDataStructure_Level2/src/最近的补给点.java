import java.util.Arrays;
import java.util.Scanner;
public class 最近的补给点 {
	static Scanner cin=new Scanner(System.in);
	static final int N=(int)(5e5+10);
	static class Node{
		long x,y;
	}
	public static void main(String[] args) {
		
		int n=cin.nextInt();
		Node[] a=new Node[n];
		for(int i=0;i<n;i++) {
			a[i]=new Node();
			a[i].x=cin.nextInt();
			a[i].y=cin.nextInt();
		}
		
		
		Arrays.sort(a,(o1,o2)->{
			long d1=o1.x*o1.x+o1.y*o1.y;
			long d2=o2.x*o2.x+o2.y*o2.y;
			
			if(d1!=d2) {
				return Long.compare(d1, d2);
			}
			if(o1.x!=o2.x) {
				return Long.compare(o1.x, o2.x);
			}
			
			return Long.compare(o1.y, o2.y);
		});
		
		for(int i=0;i<n;i++) {
			System.out.print(a[i].x+" "+a[i].y);
			if(i!=n-1)System.out.println();
		}
	}
}
