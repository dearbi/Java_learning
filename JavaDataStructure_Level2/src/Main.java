import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Scanner;

public class Main {
	static Scanner cin = new Scanner(System.in);
	public static void main(String[] args) {
		int m= cin.nextInt();
		for(int i=0;i<m;i++){
			Stack<Integer> stack=new Stack<>();
			int x= cin.nextInt();
			while(x!=-1){
				stack.push(x);
				x=cin.nextInt();
			}

			int size=stack.size();
			for(int j=0;j< size;j++){
				System.out.print(stack.pop());
				if(j!=size-1){
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}