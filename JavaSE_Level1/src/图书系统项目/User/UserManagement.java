package 图书系统项目.User;

import 图书系统项目.User.Factory.AdminUserFactory;
import 图书系统项目.User.Factory.IUserFactory;
import 图书系统项目.User.Factory.NormalUserFactory;

public class UserManagement {
    public static void main(String[] args) {
        IUserFactory adminUserFactory = new AdminUserFactory();
        User adminUser = adminUserFactory.createUser("刘备",1);
        IUserFactory normalUserFactory = new NormalUserFactory();
        User normalUser1 = normalUserFactory.createUser("关⽻",2);
        User normalUser2 = normalUserFactory.createUser("张⻜",3);
        ProxyUser proxyUserAdmin = new ProxyUser(adminUser);
        ProxyUser proxyUserNormal1 = new ProxyUser(normalUser1);
        ProxyUser proxyUserNormal2 = new ProxyUser(normalUser2);
        proxyUserAdmin.addBook("Java编程思想");
        proxyUserNormal1.borrowBook("设计模式");
    }

}
