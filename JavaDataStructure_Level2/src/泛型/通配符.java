package 泛型;

class Message<T> {
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}

public class 通配符 {
    public static void fun(Message<?> temp){
        System.out.println(temp.getMessage());
    }

    public static void main(String[] args) {
        Message<String> message = new Message<String>() ;
        message.setMessage("hello");
        fun(message);
    }
}
