package com.cxg.service;

import com.cxg.enums.SexEnum;
import com.cxg.pojo.Course;
import com.cxg.pojo.Student;

import java.util.List;

public interface StudentService {
//    根据学生名字查询
    List<Student> findByStudentName(String studentName,Integer currentPage,Integer pageSize);
//    根据学生性别查询
    List<Student> findByStudentSex(SexEnum sexEnum,Integer currentPage,Integer pageSize);
//    根据学生年级查询
    List<Student> findByStudentGrade(Integer studentGrate,Integer currentPage,Integer pageSize);
//    根据学生id查询不带课程信息
    Student findById(Long id);
//    存入学生信息
    boolean saveStudent(Student student);
//    更新学生信息
    boolean updateStudentById(Student student);
//    根据学生id删除
    boolean deleteStudentById(Student student);
//    根据学生id查询携带课程信息
    Student findByIdWithCourse(Long id);
//    存入学生信息携带课程信息
    boolean saveStudentWithCourse(Student student, Course course);
}
