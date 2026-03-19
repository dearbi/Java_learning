import java.util.PriorityQueue;
import java.util.Scanner;

public class 优先级队列 {
    static Scanner cin=new Scanner(System.in);
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int n=cin.nextInt();
        while(n-->0){
            String op=cin.next();

            if(op.equals("push")){
                int x=cin.nextInt();
                pq.add(x);
            }else if(op.equals("remove")){
                if(pq.isEmpty()){
                    System.out.println("empty");
                }else{
                    pq.poll();
                }
            }else if(op.equals("print")){
                int x=cin.nextInt();
                for(int i=1;i<=x;i++){
                    System.out.print(pq.poll());
                    if(i!=x) System.out.print(" ");
                }
                System.out.println();
            }else{
                if(pq.isEmpty()){
                    System.out.println("empty");
                }else{
                    System.out.println(pq.peek());
                }
            }
        }
    }
}
