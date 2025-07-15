package 图书系统项目.User.Factory;

import 图书系统项目.User.*;

public class AdminUserFactory implements IUserFactory {
    @Override
    public User createUser(String name, int userID) {

        return new AdminUser(name, userID);
    }
}


