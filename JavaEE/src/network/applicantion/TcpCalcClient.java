package network.applicantion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// 算术运算的客户端
public class TcpCalcClient {
    private Socket socket = null;

    public TcpCalcClient(String serverIp, int serverPort) throws IOException {
        socket = new Socket(serverIp, serverPort);
    }

    public void start() {
        System.out.println("客户端运行中...");

        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            Scanner scannerConsole = new Scanner(System.in);
            Scanner scannerNetwork = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);

            while (true) {
                // 1. 从控制台读取用户输入的内容
                System.out.println("请输入要进行的运算 (+ - * /): ");
                String operator = scannerConsole.next();
                System.out.println("请输入第一个数字: ");
                double num1 = scannerConsole.nextDouble();
                System.out.println("请输入第二个数字: ");
                double num2 = scannerConsole.nextDouble();

                // 2. 构造请求并发送
                Request request = new Request(operator, num1, num2);
                String requestString = request.convertToString();
                printWriter.print(requestString);
                printWriter.flush();

                // 3. 读取服务器的响应结果
                if (!scannerNetwork.hasNext()) {
                    break;
                }
                String responseString = scannerNetwork.next();
                Response response = Response.convertFromString(responseString);

                // 4. 打印响应结果
                System.out.println(response.getResult());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpCalcClient client = new TcpCalcClient("127.0.0.1", 9090);
        client.start();
    }
}
