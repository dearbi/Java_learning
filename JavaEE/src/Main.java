public class Main {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
           for (int i = 0; i < 10; i++) {

           }

        }, "子线程");
        System.out.println(t.getName()+":"+t.getState());
        t.start();
        System.out.println(t.getName()+":"+t.getState());
        while(t.isAlive()){
            System.out.println(t.getName()+":"+t.getState());
        }
        System.out.println(t.getName()+":"+t.getState());

    }

}