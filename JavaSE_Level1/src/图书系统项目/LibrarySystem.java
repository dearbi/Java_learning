package 图书系统项目;

import 图书系统项目.User.Factory.AdminUserFactory;
import 图书系统项目.User.Factory.IUserFactory;
import 图书系统项目.User.Factory.NormalUserFactory;
import 图书系统项目.User.ProxyUser;
import 图书系统项目.User.User;

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        IUserFactory adminUserFactory = new AdminUserFactory();
        User adminUser = adminUserFactory.createUser("刘备", 1);
        IUserFactory normalUserFactory = new NormalUserFactory();
        User normalUser1 = normalUserFactory.createUser("关⽻", 2);
        User normalUser2 = normalUserFactory.createUser("张⻜", 3);
        /**
         * 1.4 使⽤代理模式来管理权限
         * 使⽤代理模式来控制 对象的访问
         */
        ProxyUser proxyUserAdmin = new ProxyUser(adminUser);
        ProxyUser proxyUserNormalG = new ProxyUser(normalUser1);
        ProxyUser proxyUserNormalZ = new ProxyUser(normalUser2);
        ProxyUser currentUser=selectProxyRolee(proxyUserAdmin,proxyUserNormalG,proxyUserNormalZ);
        while(true){
            int choice=currentUser.getRealUser().display();
            System.out.println(choice);
            currentUser.handleOperation(choice);
        }
    }

    public static ProxyUser selectProxyRolee(ProxyUser proxyUserAdmin, ProxyUser proxyUserNormalW, ProxyUser proxyUserNormalL){
        System.out.println("选择⻆⾊进⾏登录：");
        System.out.println("1.管理员\n2.普通⽤⼾(关⽻)\n3.普通⽤⼾(张⻜)\n4.退出系统");
        ProxyUser currentUser = null;
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                currentUser = proxyUserAdmin;
                break;
            case 2:
                currentUser = proxyUserNormalW;
                break;
            case 3:
                currentUser = proxyUserNormalL;
                break;
            case 4:
                System.exit(0);
                System.out.println("系统已退出..");
                break;
            default:
                break;
        }
        return currentUser;
    }
}
