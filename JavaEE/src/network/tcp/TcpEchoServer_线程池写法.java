package network.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TcpEchoServer_线程池写法 {
    private ServerSocket serverSocket=null;

    public TcpEchoServer_线程池写法(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() throws IOException {
        System.out.println("TCP 服务器启动(线程池版)");

        ExecutorService service = Executors.newCachedThreadPool();

        while(true) {
            //TCP每次循环，每次循环是要处理一个连接
            //一个连接里，可能包含了多个请求和响应
            Socket socket = serverSocket.accept();
            //之前是直接调用,会存在问题
//            processConnection(socket);

            //还可以使用线程池的方式，进一步减少频繁创建销毁线程的开销
            service.submit(()->{
                try {
                    processConnection(socket);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });



        }

    }

    private void processConnection(Socket socket) throws IOException {
        //一个连接中，可能会涉及多组请求/响应的交互
        System.out.printf("[%s:%d] 客户端上线！\n", socket.getInetAddress().toString(), socket.getPort());

        try(InputStream inputStream = socket.getInputStream()) {
            OutputStream outputStream = socket.getOutputStream();
            //一次循环，就是处理一组请求/响应
            Scanner scanner = new Scanner(inputStream);
            PrintWriter printWriter = new PrintWriter(outputStream);
            while(true) {
                //1.读取请求并解析
                if (!scanner.hasNextLine()) {
                    // 判定当前tcp的连接是否断开
                    break;
                }
                String request = scanner.nextLine();

                //2.根据请求计算响应
                String response = process(request);

                //3.把响应写回到客户端
                printWriter.println(response);
                printWriter.flush();

                //4.打印日志
                System.out.printf("[%s:%d] req: %s; resp: %s\n",
                        socket.getInetAddress().toString(),
                        socket.getPort(), request, response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("[%s:%d] 客户端下线！\n", socket.getInetAddress().toString(), socket.getPort());
            socket.close();
        }
    }

    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpEchoServer_线程池写法 server = new TcpEchoServer_线程池写法(9090);
        server.start();
    }
}

