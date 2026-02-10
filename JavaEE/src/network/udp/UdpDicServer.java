package network.udp;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;

public class UdpDicServer extends UdpEchoServer{
    private Map<String,String> dict = new HashMap<>();

    public UdpDicServer(int port) throws SocketException {
        super(port);

        dict.put("hello","你好");
        dict.put("world","世界");
        dict.put("java","java");
        dict.put("udp","用户数据报协议");
        dict.put("http","http");
        dict.put("https","https");
        dict.put("file","文件");
    }

    //重写process

    @Override
    public String process(String request) {
        //实现 英文->中文
        return dict.getOrDefault(request,"没有找到这个单词");
    }

    public static void main(String[] args) throws IOException {
        UdpDicServer server = new UdpDicServer(9090);

        server.start();
    }
}
