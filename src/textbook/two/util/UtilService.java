package textbook.two.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import textbook.two.service.impl.UserServiceImpl;

public class UtilService {
    private static UserServiceImpl userService = null;

    public static UserServiceImpl getUserService(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        userService = ac.getBean("userServiceImpl", UserServiceImpl.class);
        return userService;
    }

}
