package network.applicanttion;

public class Response {
    private double result;
    public Response(double result) {
        this.result = result;
    }

    public String convertToString() {
        return String.format("%f\n", result);
    }

    public static Response convertFromString(String responseString) {
        double result = Double.parseDouble(responseString);
        return new Response(result);
    }

}
