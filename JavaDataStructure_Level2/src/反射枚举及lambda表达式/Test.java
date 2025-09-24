package 反射枚举及lambda表达式;

public class Test {
    public static void main(String[] args) {
        NoParameterNoReturn noParameterNoReturn = () -> {
            System.out.println("test");
        };
        /*NoParameterNoReturn noParameterNoReturn = new NoParameterNoReturn() {
            @Override
            public void test() {
                System.out.println("test");
            }
        };*/
        noParameterNoReturn.test();

        NoParameterReturn noParameterReturn = () -> 10;
        System.out.println(noParameterReturn.test());

        OneParameterNoReturn oneParameterNoReturn = (a) -> {
            System.out.println("test" + a);
        };
        oneParameterNoReturn.test(1);

        MoreParameterNoReturn moreParameterNoReturn = (a, b) -> {
            System.out.println("test" + a + b);
        };
        moreParameterNoReturn.test(1, 2);
    }

}
