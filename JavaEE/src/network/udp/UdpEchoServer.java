package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    //先创建socket对象
    private DatagramSocket socket=null;

    public UdpEchoServer(int port) throws SocketException {
        socket=new DatagramSocket(port);
    }

    public void start() throws IOException {
        //启动服务器
        System.out.println("服务器启动");

        //服务器，需要不断的处理客户端的请求
        while(true){
            //循环一次，就处理一次客户端的请求
            //1. 先从客户端接收请求，解析出请求内容
            DatagramPacket requestPacket=new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket);
            //为了处理请求方便，把里面的载荷数据提取出来
            String request= new String(requestPacket.getData(), 0, requestPacket.getLength());
            //2. 根据请求内容，组织响应结果
            String response=process(request);
            //3. 把响应结果返回给客户端
            DatagramPacket responsePacket=new DatagramPacket(response.getBytes(), response.getBytes().length, requestPacket.getSocketAddress());
            socket.send(responsePacket);

            //4.打印日志
            System.out.printf("[%s:%d] req: %s; resp: %s\n",
            requestPacket.getAddress().toString(),
            requestPacket.getPort(),
            request,
            response);
        }
    }


    //此处是回显服务器，相应和请求内容完全一致
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        //端口号是一个整数，我们可以随意指定.
        //端口号范围：0~65535
        //其中0~1023是系统保留端口号，不建议使用
        //1024~65535是普通端口号，建议使用
        UdpEchoServer server=new UdpEchoServer(9090);
        server.start();

    }
}
