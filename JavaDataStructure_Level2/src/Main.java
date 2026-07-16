import java.util.PriorityQueue;
import java.util.Scanner;
/**
 https://www.lanqiao.cn/courses/52478/learning/?id=4185473&compatibility=false
 **/

public class Main {
	static class Pair{
		int first;
		int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}
	static  Scanner cin=new Scanner(System.in);
	public static void main(String[] args) {
		int k=cin.nextInt();
		int n=cin.nextInt();

		int[] a=new int[k+1];//a[i]：第i个怪物初次击败所需的值
		int[] b=new int[k+1];//a[i]：第i个怪物第二次击败所需的值

		for(int i=1;i<=k;i++){
			a[i]=cin.nextInt();
			b[i]=cin.nextInt();
		}

		PriorityQueue<Pair> q=new PriorityQueue<>((x,y)->Integer.compare(x.first,y.first));

		int ans1=0;
		int ans2=0;

		//情况一：不挑战第k个怪物
		//将前k-1个怪物的初始状态a[i]放入优先队列
		for(int i=1;i<k;i++){
			q.offer(new Pair(a[i],i));
		}

		int temp=n;
		while(temp>0){
			Pair x=q.poll();
			ans1+=x.first;
			q.offer(new Pair(b[x.second],x.second));
			temp--;
		}

		//挑战最后一个怪物
		if(n>=k){
			ans2=0;
			q.clear();

			for(int i=1;i<=k;i++){
				ans2+=a[i];
				q.offer(new Pair(b[i],i));
			}

			n-=k;
			while(n>0){
				Pair x=q.poll();
				ans2+=x.first;
				q.offer(new Pair(b[x.second],x.second));
				n--;
			}

		}

		System.out.println(Math.min(ans1,ans2));

	}
}