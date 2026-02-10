package network.tcp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TcpDictServer extends TcpEchoServer_线程池写法{

    // 字典映射表：中文 -> 英文
    private Map<String, String> dictionary;

    public TcpDictServer(int port) throws IOException {
        super(port);
        initDictionary();
    }

    // 初始化字典
    private void initDictionary() {
        dictionary = new HashMap<>();
        dictionary.put("猫", "cat");
        dictionary.put("狗", "dog");
        dictionary.put("苹果", "apple");
        dictionary.put("香蕉", "banana");
        dictionary.put("学生", "student");
        dictionary.put("老师", "teacher");
        dictionary.put("电脑", "computer");
        dictionary.put("书", "book");
        dictionary.put("钢笔", "pen");
        dictionary.put("椅子", "chair");
        dictionary.put("桌子", "table");
        dictionary.put("水", "water");
        dictionary.put("牛奶", "milk");
        dictionary.put("面包", "bread");
        dictionary.put("米饭", "rice");
        dictionary.put("鸡蛋", "egg");
        dictionary.put("太阳", "sun");
        dictionary.put("月亮", "moon");
        dictionary.put("星星", "star");
        dictionary.put("天空", "sky");
        dictionary.put("地球", "earth");
    }

    // 重写process方法，实现字典翻译功能
    @Override
     public String process(String request) {
        String translation = dictionary.get(request);
        if (translation != null) {
            return translation;
        } else {
            return "未找到该单词";
        }
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer server = new TcpDictServer(9090);
        server.start();
    }
}
