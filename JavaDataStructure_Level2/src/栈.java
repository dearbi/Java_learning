import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 栈 {
	static Scanner cin=new Scanner(System.in);
	static final int N=(int)(5e5+10);
public static void main(String[] args) {
	int n=cin.nextInt();
	Queue<Integer> queue=new LinkedList<>();
	while(n-->0) {
		String string=cin.next();
		if(string.equals("push")) {
			int x=cin.nextInt();
			queue.add(x);
		}else if(string.equals("pop")) {
			if(!queue.isEmpty()) queue.poll();
		}else if(string.equals("empty")) {
			if(queue.isEmpty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}else {
			if(queue.isEmpty()) {
				System.out.println("empty");
			}else {
				System.out.println(queue.peek());
			}
		}
	}
	
}
}
