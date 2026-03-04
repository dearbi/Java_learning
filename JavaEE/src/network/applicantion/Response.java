package network.applicantion;

// 表示一个响应数据
public class Response {
    private double result;

    public Response(double result) {
        this.result = result;
    }

    public String convertToString() {
        return String.format("%f\n", result);
    }

    public static Response convertFromString(String response) {
        double result = Double.parseDouble(response);
        return new Response(result);
    }

    public double getResult() {
        return result;
    }
}
