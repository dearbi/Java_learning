package 单例模式;

public class School {
    public static void main(String[] args) {
        Principal principal1 = Principal.getInstance();
        Principal principal2 = Principal.getInstance();

        principal1.announcement("今天放假");
        principal2.approveDocument("食堂饭菜每次都得加热");

        // 检查是否是同⼀个校⻓实例
        System.out.println("上述两个是同⼀位校⻓吗？ " + (principal1 ==
                principal2));

    }
}
