package 单例模式;

public class Principal {
    private static Principal principal;


    private String name;

    private Principal() {
        name = "王校⻓";
    }

    // 获取校⻓实例的公共⽅法
    public static Principal getInstance() {
        if (principal == null) {
            principal = new Principal();
        }
        return principal;
    }
    // 校⻓的⼀些⽅法
    public void announcement(String message) {
        System.out.println(name + "通知：" + message);
    }
    public void approveDocument(String file) {
        System.out.println(name + "审批通过：" + file);
    }


}
