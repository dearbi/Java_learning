package 内部类;

class OuterClass {
    public int data1=1;
    public int data2=2;
    public static int data3=3;

    static class InnerClass {
        public int dada4=4;
        public int dada5=5;
        public static int data6=6;

        public void testInner(){
            System.out.println("InnerClass");
//            System.out.println(data1);
        }
    }

    public void test() {
        System.out.println("OuterClass");
    }

}

class OuterClass2 {
    public int data1=1;
    public int data2=2;
    public static int data3=3;

    class InnerClass{
        public int data1=999;
        public int data4= 4;
        private int data5=5;
        public static int data6 = 6;

        public void test() {
            System.out.println(data1);
            System.out.println(OuterClass2.this.data1);
            System.out.println(data2);
            System.out.println(data3);
            System.out.println(data4);
            System.out.println(data5);
            System.out.println(data6);
        }
    }
}
interface Greeting {
    void greet();
}

public class Test {
    public static void main(String[] args) {
        Greeting g=new Greeting(){

            @Override
            public void greet() {
                System.out.println("hahaha");
            }
        };
        g.greet();
    }
    public static void main2(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        OuterClass2.InnerClass innerClass=outerClass2.new InnerClass();
        innerClass.test();
    }
    public static void main1(String[] args) {
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();
        innerClass.testInner();
    }
}
