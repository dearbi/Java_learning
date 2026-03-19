import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 队列 {
	static Scanner cin=new Scanner(System.in);
	static final int N=(int)(2e5+10);
	static int queue[]=new int[N];
	static int head=0,tail=0;
	static Queue<Integer> queue2=new ArrayDeque<>();
public static void main(String[] args) {
	int n=cin.nextInt();
	while(n-->0) {
		String op=cin.next();
		if(op.equals("push")) {
			int x=cin.nextInt();
			queue[tail++]=x;
		}else if(op.equals("pop")) {
			if(tail!=head) {
				head++;
			}
		}else if(op.equals("empty")) {
			if(head==tail) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}else {
			if(head==tail) {
				System.out.println("empty");
			}else {
				System.out.println(queue[head]);
			}
		}
	}
	
}
}
