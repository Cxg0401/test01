package com.cxg;

import com.cxg.config.MyPageConfig;
import com.cxg.enums.SexEnum;
import com.cxg.pojo.Course;
import com.cxg.pojo.Student;
import com.cxg.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentTest {

    @Autowired
    private StudentService studentService;
    //    页码信息
    @Autowired
    private MyPageConfig myPageConfig;
    @Test
    void testInsert() {
        Student student = new Student();
        student.setStudName("张三");
        student.setSex(SexEnum.MAN);
        student.setGrade(1);
        boolean b = studentService.saveStudent(student);
        if (b){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }
    }

    @Test
    public void testSelect(){
        List<Student> students_name = studentService.findByStudentName("王",myPageConfig.getCurrentPage(),myPageConfig.getPageSize());
        System.out.println("根据学生名字模糊查询："+students_name);
        List<Student> students_sex = studentService.findByStudentSex(SexEnum.WOMAN,myPageConfig.getCurrentPage(),myPageConfig.getPageSize());
        System.out.println("根据学生性别查询："+students_sex);
        List<Student> students_grade = studentService.findByStudentGrade(1,myPageConfig.getCurrentPage(),myPageConfig.getPageSize());
        System.out.println("根据学生年级查询："+students_grade);
        Student studentWithCourse = studentService.findByIdWithCourse(1L);
        System.out.println("根据id查询学生携带课程信息：\n"+studentWithCourse);
    }

    @Test
    public void testUpdate(){
        List<Student> students = studentService.findByStudentName("李四",myPageConfig.getCurrentPage(),myPageConfig.getPageSize());
        Student student_select = students.get(0);
        Student student = studentService.findById(student_select.getId());
        student.setStudName("王五");
        boolean b = studentService.updateStudentById(student);
        if (b){
            System.out.println("更新成功");
        }else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testDelete(){
        Student student = new Student();
        student.setId(1L);
        boolean b = studentService.deleteStudentById(student);
        if (b){
            System.out.println("删除成功");
        }else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void testSaveStudentWithCourse(){
        Student student = new Student();
        student.setId(1L);
        Course course = new Course();
        course.setId(3L);
        boolean b = studentService.saveStudentWithCourse(student,course);
        System.out.println(b);
    }



}
