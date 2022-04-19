package com.cxg;

import com.cxg.config.MyPageConfig;
import com.cxg.pojo.Course;
import com.cxg.service.CourseService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseTest {
    @Autowired
    private CourseService courseService;
//    页码信息
    @Autowired
    private MyPageConfig myPageConfig;

    @Test
    public void testInsert(){
        Course course = new Course();
        course.setCourseName("计算机3");
        course.setCredit(6F);
        boolean b = courseService.saveCourse(course);
        System.out.println(b);

    }
    @Test
    public void testSelect(){
//        根据名字查询
        Course course = courseService.findByCourseName("计算机");
        System.out.println("根据课程名查询："+course);
        List<Course> courses_all = courseService.findAllCourse(myPageConfig.getCurrentPage(), myPageConfig.getPageSize());
        System.out.println("查询所有："+courses_all);
        List<Course> courses_credit = courseService.findCourseByCredit(6L, myPageConfig.getCurrentPage(), myPageConfig.getPageSize());
        System.out.println("根据学分查询"+courses_credit);
    }

    @Test
    public void testDelete(){

        boolean b = courseService.deleteCourseById(1L);
        System.out.println(b);
    }

    @Test
    public void testUpdate(){
        Course course = new Course();
        course.setCourseName("计算机New");
        course.setCredit(8F);
        course.setId(2L);
        boolean b = courseService.updateCourseById(course);
        System.out.println(b);
    }






}
