package textbook.two.service;

import textbook.two.pojo.User;

public interface UserService {
    //用户登入
    User login(User user);

    //用户注册
    int addUser(User user);

    //cheek用户注册的账号是否操作
    User checkRegister(User user);
}
