package network.applicanttion;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//算数运算服务器
public class TcpCalcServer {
    private ServerSocket serverSocket = null;

    public TcpCalcServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("服务器启动");

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        while (true) {
            Socket socket = serverSocket.accept();
            executorService.submit(() -> {
                processConnection(socket);
            });
        }
    }


    //处理一个连接
    private void processConnection(Socket socket) {
        System.out.printf("[%s:%d] 客户端上线\n", socket.getInetAddress().toString(), socket.getPort());

        try (InputStream outputStream = socket.getInputStream()) {
            OutputStream outputStream1 = socket.getOutputStream();

            Scanner scanner = new Scanner(outputStream);
            PrintWriter printWriter = new PrintWriter(outputStream1);

            while (true) {
                //1. 先从客户端读取一个请求
                if (!scanner.hasNextLine()) {
                    break;
                }
                String requestString = scanner.next();

                //相对于前面的的EchoServer,多了一步“反序列化”
                Request request = Request.convertFromString(requestString);

                //2. 根据请求，进行计算
                Response response = process(request);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("[%s:%d] 客户端下线\n", socket.getInetAddress().toString(), socket.getPort());
    }

    private Response process(Request request) {
        //根据当前参数和运算符完成计算，并且构造响应
        if(request.getOperator().equals("+")) {
            return new Response(request.getNum1() + request.getNum2());
        }else if(request.getOperator().equals("-")) {
            return new Response(request.getNum1() - request.getNum2());
        }else if(request.getOperator().equals("*")) {
            return new Response(request.getNum1() * request.getNum2());
        }else if(request.getOperator().equals("/")) {
            return new Response(request.getNum1() / request.getNum2());
        }else{
            throw new RuntimeException("不支持的运算符"+request.getOperator());
        }

    }
}
