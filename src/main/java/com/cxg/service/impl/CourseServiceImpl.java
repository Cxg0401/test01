package com.cxg.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxg.mapper.CourseMapper;
import com.cxg.pojo.Course;
import com.cxg.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course findByCourseName(String courseName) {
        Course course = courseMapper.selectOne(new LambdaQueryWrapper<Course>().eq(Course::getCourseName, courseName));
        return course;
    }

    @Override
    public List<Course> findCourseByCredit(Long credit, Integer currentPage, Integer pageSize) {
        Page<Course> page = new Page<>(currentPage,pageSize);
        IPage<Course> iPage = courseMapper.selectPage(page, new LambdaQueryWrapper<Course>().eq(Course::getCredit,credit));
        return iPage.getRecords();
    }

    @Override
    public List<Course> findAllCourse(Integer currentPage, Integer pageSize) {
        Page<Course> page = new Page<>(currentPage,pageSize);
        IPage<Course> iPage = courseMapper.selectPage(page, null);
        List<Course> course = iPage.getRecords();
        return course;
    }


    @Override
    public boolean deleteCourseById(Long courseId) {
        Integer count = courseMapper.findStudentCountByCourseId(courseId);
//        判断是否有学生使用
        if (count>0){
           return false;
        }
        int delete = courseMapper.deleteById(courseId);
        return delete>0;
    }

    @Override
    public boolean saveCourse(Course course) {
        int insert = courseMapper.insert(course);
        return insert>0;
    }

    @Override
    public boolean updateCourseById(Course course) {
        int update = courseMapper.update(course, new LambdaQueryWrapper<Course>().eq(Course::getId, course.getId()));
        return update>0;
    }
}
