package 工具类;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal doubleNum = new BigDecimal(1.99);
        System.out.println(doubleNum);
        BigDecimal stringNum = new BigDecimal("2.99");
        System.out.println(stringNum);
    }
}
