package network.applicantion;

// 表示一个请求
public class Request {
    // 支持 + - * /
    private String operator;
    private double num1;
    private double num2;

    public Request(String operator, double num1, double num2) {
        this.operator = operator;
        this.num1 = num1;
        this.num2 = num2;
    }

    // 能够把这个对象转成字符串
    public String convertToString() {
        // String.format 就类似于 printf , 把结果构造到 String 中.
        return String.format("%s,%f,%f\n", operator, num1, num2);
    }

    public static Request convertFromString(String request) {
        // 1. 获取参数
        String[] split = request.split(",");
        String operator = split[0];
        double num1 = Double.parseDouble(split[1]);
        double num2 = Double.parseDouble(split[2]);

        // 2. 创建对象
        return new Request(operator, num1, num2);
    }

    public String getOperator() {
        return operator;
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }
}
