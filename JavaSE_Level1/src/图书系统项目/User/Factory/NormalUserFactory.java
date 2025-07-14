package 图书系统项目.User.Factory;

import 图书系统项目.User.NormalUser;
import 图书系统项目.User.User;

public class NormalUserFactory implements IUserFactory {
    @Override
    public User createUser(String name, int userID) {
        return new NormalUser(name, userID);
    }

}
