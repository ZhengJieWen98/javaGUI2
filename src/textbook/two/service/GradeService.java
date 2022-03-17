package textbook.two.service;

import textbook.two.pojo.Grade;
import textbook.two.pojo.Textbook;

import java.util.List;

public interface GradeService {
    //添加班级信息
    int addGrade(Grade grade);
    //修改班级
    int updGrade(Grade grade);
    //删除班级信息
    int delGrade(int id);
    //查看所有班级信息
    List<Grade> selGrade();



}
