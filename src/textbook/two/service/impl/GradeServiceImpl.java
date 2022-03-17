package textbook.two.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import textbook.two.mapper.GradeMapper;
import textbook.two.pojo.Grade;
import textbook.two.pojo.Textbook;
import textbook.two.service.GradeService;

import java.util.List;
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeMapper gradeMapper = null;

    public GradeMapper getGradeMapper() {
        return gradeMapper;
    }

    public void setGradeMapper(GradeMapper gradeMapper) {
        this.gradeMapper = gradeMapper;
    }

    @Override
    public int addGrade(Grade grade) {
        return gradeMapper.addGrade(grade);
    }

    @Override
    public int updGrade(Grade grade) {
        return gradeMapper.updGrade(grade);
    }

    @Override
    public int delGrade(int id) {
        return gradeMapper.delGrade(id);
    }

    @Override
    public List<Grade> selGrade() {
        return gradeMapper.selGrade();
    }
}
