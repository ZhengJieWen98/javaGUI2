package textbook.two.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import textbook.two.mapper.UserMapper;
import textbook.two.pojo.User;
import textbook.two.service.impl.UserServiceImpl;
import textbook.two.util.UtilService;

public class MyTest {
    @Autowired
    private UserServiceImpl userService = null;

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public static void main(String[] ar) {
//        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        UserServiceImpl service = ac.getBean("userServiceImpl", UserServiceImpl.class);
        UserServiceImpl userService = UtilService.getUserService();
        User user = new User("18782623892","123456789");
        User login = userService.login(user);
        System.out.println(login);


    }
}
