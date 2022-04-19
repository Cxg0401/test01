package com.cxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxg.enums.SexEnum;
import com.cxg.mapper.StudentMapper;
import com.cxg.pojo.Course;
import com.cxg.pojo.Student;
import com.cxg.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> findByStudentName(String studentName,Integer currentPage,Integer pageSize) {
        Page<Student> page = new Page<>(currentPage,pageSize);
        IPage<Student> studentIPage = studentMapper.selectPage(page, new LambdaQueryWrapper<Student>().like(Student::getStudName, studentName));
        List<Student> students = studentIPage.getRecords();
        return students;
    }

    @Override
    public List<Student> findByStudentSex(SexEnum sexEnum,Integer currentPage,Integer pageSize) {
        Page<Student> page = new Page<>(currentPage,pageSize);
        IPage<Student> studentIPage = studentMapper.selectPage(page, new LambdaQueryWrapper<Student>().eq(Student::getSex, sexEnum));
        List<Student> students = studentIPage.getRecords();
        return students;
    }

    @Override
    public List<Student> findByStudentGrade(Integer studentGrate,Integer currentPage,Integer pageSize) {
        Page<Student> page = new Page<>(currentPage,pageSize);
        IPage<Student> iPage = studentMapper.selectPage(page, new LambdaQueryWrapper<Student>().eq(Student::getGrade, studentGrate));
        List<Student> students = iPage.getRecords();
        return students;
    }



    @Override
    public boolean saveStudent(Student student) {
        int insert = studentMapper.insert(student);
        return insert>0;
    }

    @Override
    public boolean updateStudentById(Student student) {
        int update = studentMapper.update(student, new LambdaQueryWrapper<Student>().eq(Student::getId, student.getId()));
        return update>0;
    }

    @Override
    public boolean deleteStudentById(Student student) {
        int delete = studentMapper.deleteById(student.getId());
        return delete>0;
    }

    @Override
    public Student findByIdWithCourse(Long id) {
        Student student = studentMapper.findByStudentIdWithCourse(id);
        return student;
    }

    @Override
    public boolean saveStudentWithCourse(Student student, Course course) {

        boolean result = studentMapper.saveStudentCourse(student.getId(), course.getId());

        return result;
    }

    @Override
    public Student findById(Long id) {
        Student student = studentMapper.selectOne(new LambdaQueryWrapper<Student>().eq(Student::getId, id));
        return student;
    }
}
