package 图书系统项目.User.Factory;

import 图书系统项目.User.User;

public interface IUserFactory {
    User createUser(String username, int password);
}
