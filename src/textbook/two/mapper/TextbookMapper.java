package textbook.two.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import textbook.two.pojo.Grade;
import textbook.two.pojo.Textbook;

import java.util.List;

public interface TextbookMapper {
    //添加班级信息
    @Insert("insert into textbook values(default,#{userID},#{textbookName},#{press},#{price})")
    int addTextbook(Textbook textbook);
    //修改班级
    @Update("update textbook set textbookName=#{textbookName},press=#{press},price=#{price} where id=#{id}")
    int updTextbook(Textbook textbook);
    //删除班级信息
    @Delete("delete from textbook where id=#{0}")
    int delTextbook(int id);
    //查看所有班级信息
    @Select("select * from textbook")
    List<Textbook> selTextbook();
}
