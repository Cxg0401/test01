package com.cxg.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxg.pojo.Course;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper extends BaseMapper<Course>{
    @Select("SELECT COUNT(stud_id) FROM t_student_course tsc,t_course tc WHERE tsc.course_id=tc.id AND tc.id=#{courseId}")
    Integer findStudentCountByCourseId(Long courseId);
}
