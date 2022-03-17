package textbook.two.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import textbook.two.pojo.User;

public interface UserMapper {
    //用户登入
    @Select("select * from user where account=#{account} and password=#{password}")
    User login(User user);

    //用户注册
    @Insert("insert into user values(default,#{account},#{password})")
    int addUser(User user);

    //cheek用户注册的账号是否操作
    User checkRegister(User user);
}
