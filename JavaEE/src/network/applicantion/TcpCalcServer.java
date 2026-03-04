package network.applicantion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 进行算术运算的服务器程序
public class TcpCalcServer {
    private ServerSocket serverSocket = null;

    public TcpCalcServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动...");

        ExecutorService service = Executors.newCachedThreadPool();

        while (true) {
            Socket socket = serverSocket.accept();
            service.submit(() -> {
                try {
                    processConnection(socket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    // 处理一个连接
    public void processConnection(Socket socket) throws IOException {
        System.out.printf("[%s:%d] 客户端上线!", socket.getInetAddress().toString(), socket.getPort());

        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);

            while (true) {
                // 1. 读取请求并解析
                if (!scanner.hasNext()) {
                    break;
                }
                String requestString = scanner.next();
                // 相比于前面的 EchoServer, 多了一步 "反序列化"
                Request request = Request.convertFromString(requestString);

                // 2. 根据请求计算响应
                Response response = process(request);

                // 3. 把响应写回到客户端
                String responseString = response.convertToString();
                // 构造 String 的时候, 已经带了 \n, 直接 print 写入即可.
                printWriter.print(responseString);
                printWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("[%s:%d] 客户端下线!\n", socket.getInetAddress().toString(), socket.getPort());
            socket.close();
        }
    }

    private Response process(Request request) {
        // 根据当前参数和运算符完成计算, 并且构造响应
        if (request.getOperator().equals("+")) {
            return new Response(request.getNum1() + request.getNum2());
        } else if (request.getOperator().equals("-")) {
            return new Response(request.getNum1() - request.getNum2());
        } else if (request.getOperator().equals("*")) {
            return new Response(request.getNum1() * request.getNum2());
        } else if (request.getOperator().equals("/")) {
            return new Response(request.getNum1() / request.getNum2());
        } else {
            throw new RuntimeException("不支持的运算符: " + request.getOperator());
        }
    }

    public static void main(String[] args) throws IOException {
        TcpCalcServer server = new TcpCalcServer(9090);
        server.start();
    }
}
