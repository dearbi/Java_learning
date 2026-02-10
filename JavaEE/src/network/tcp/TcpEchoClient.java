package network.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket=null;

    //需要指定，要连接的服务器的ip和端口号
    public TcpEchoClient(String serverIp, int serverPort) throws IOException {
        this.socket = new Socket(serverIp, serverPort);
    }
    public void start() throws IOException {
        System.out.println("TCP 客户端启动");
        try(InputStream inputStream = socket.getInputStream()) {
                OutputStream outputStream = socket.getOutputStream();
                Scanner scannerConsole = new Scanner(System.in);
                Scanner scannerNetwork = new Scanner(inputStream);
                PrintWriter printWriter = new PrintWriter(outputStream);
            while(true) {
                // 1. 从控制台读取用户输入
                System.out.print("->");
                String request = scannerConsole.next();

                // 2. 把用户输入的字符串作为请求发送给服务器
                printWriter.println(request);
                printWriter.flush();
                // 3. 从服务器读取响应
                if (!scannerNetwork.hasNext()) {
                    // 判定当前tcp的连接是否断开
                    break;
                }
                String response = scannerNetwork.next();
                // 4. 把响应打印到控制台
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
