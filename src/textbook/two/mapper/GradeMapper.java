package textbook.two.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import textbook.two.pojo.Grade;
import textbook.two.pojo.Textbook;

import java.util.List;

public interface GradeMapper {
    //添加班级信息
    @Insert("insert into grade values(default,#{userID},#{grade},#{major},#{studentCount})")
    int addGrade(Grade grade);
    //修改班级
    @Update("update grade set grade=#{grade},major=#{major},studentCount=#{studentCount} where id=#{id}")
    int updGrade(Grade grade);
    //删除班级信息
    @Delete("delete from grade where id=#{0}")
    int delGrade(int id);
    //查看所有班级信息
    @Select("select * from grade")
    List<Grade> selGrade();
}
