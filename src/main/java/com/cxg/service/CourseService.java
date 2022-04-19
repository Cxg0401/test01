package com.cxg.service;


import com.cxg.pojo.Course;

import java.util.List;

public interface CourseService {
//        根据课程名字查询
        Course findByCourseName(String courseName);
//        根据学分查询
        List<Course> findCourseByCredit(Long credit,Integer currentPage,Integer pageSize);
//        查询所有课程
        List<Course> findAllCourse(Integer currentPage,Integer pageSize);
//        根据课程id删除
        boolean deleteCourseById(Long courseId);
//        存入课程
        boolean saveCourse(Course course);
//        更新课程
        boolean updateCourseById(Course course);
}
