package 图书系统项目.utils;

import 图书系统项目.User.AdminUser;
import 图书系统项目.User.Factory.AdminUserFactory;
import 图书系统项目.User.Factory.IUserFactory;
import 图书系统项目.User.Factory.NormalUserFactory;
import 图书系统项目.User.NormalUser;
import 图书系统项目.User.ProxyUser;
import 图书系统项目.User.User;

public class LibrarySystem {
    public static void main(String[] args) {
        IUserFactory adminUserFactory = new AdminUserFactory();
        User adminUser = adminUserFactory.createUser("刘备",1);
        IUserFactory normalUserFactory = new NormalUserFactory();
        User normalUser1 = normalUserFactory.createUser("关⽻",2);
        User normalUser2 = normalUserFactory.createUser("张⻜",3);
        /**
         * 1.4 使⽤代理模式来管理权限
         * 使⽤代理模式来控制 对象的访问
         */
        ProxyUser proxyUserAdmin = new ProxyUser(adminUser);
        ProxyUser proxyUserNormalG = new ProxyUser(normalUser1);
        ProxyUser proxyUserNormalZ = new ProxyUser(normalUser2);
    }
}
