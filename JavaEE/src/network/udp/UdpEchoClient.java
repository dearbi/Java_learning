package network.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket=null;
    private String serverIp;
    private int serverPort;

    public UdpEchoClient(String serverIP,int serverPort) throws SocketException {
        socket = new DatagramSocket();
        this.serverIp=serverIP;
        this.serverPort=serverPort;
    }
    public void start() throws IOException {
        System.out.println("客户端启动");

        //客户端，也需要不断的和服务器进行交互
        //每循环一次，就从控制台读取一个输入的数据，把这个数据发送到服务器，读取服务器的响应
        Scanner scanner = new Scanner(System.in);
        while(true){
            //1. 先从控制台读取一个输入的数据
            System.out.println("->");
            String request = scanner.nextLine();

            //2. 把这个数据发送到服务器
            DatagramPacket requestPacket=new DatagramPacket(request.getBytes(), request.getBytes().length, InetAddress.getByName(serverIp), this.serverPort);
            socket.send(requestPacket);

            //3. 从服务器读取响应
            DatagramPacket responsePacket=new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);
            String response=new String(responsePacket.getData(), 0, responsePacket.getLength());

            //4. 打印响应结果
            System.out.println(response);

        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1",9090);
        client.start();
    }
}
