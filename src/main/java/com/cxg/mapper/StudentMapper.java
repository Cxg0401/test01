package com.cxg.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.cxg.pojo.Course;
import com.cxg.pojo.Student;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper extends BaseMapper<Student> {
//      查询学生携带课程信息
        Student findByStudentIdWithCourse(Long studentId);
        @Insert("INSERT INTO t_student_course(stud_id,course_id) VALUES (#{studentId},#{courseId})")
        boolean saveStudentCourse(Long studentId,Long courseId);

}
