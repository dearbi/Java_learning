package network.applicanttion;

//表示一个请求
public class Request {
    //支持 + - * /
    private String operator;
    private double num1;
    private double num2;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public Request(String operator, double num1, double num2) {
        this.operator = operator;
        this.num1 = num1;
        this.num2 = num2;
    }

    //能够把这个对象转成字符串
    public String convertToString(){
        //String.format 就类似于 printf，把结果格式化到一个字符串中
        return String.format("%s %.2f %.2f", operator, num1, num2);
    }

    public static Request convertFromString(String input){
        String[] sp = input.split(" ");
        String operator = sp[0];
        double num1 = Double.parseDouble(sp[1]);
        double num2 = Double.parseDouble(sp[2]);
        return new Request(operator, num1, num2);
    }
}
