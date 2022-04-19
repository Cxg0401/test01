package com.cxg.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

import com.cxg.enums.SexEnum;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.TableName;

@Data
@TableName("t_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 学生姓名
     */
    private String studName;

    /**
     * 学生性别
     * 1-男
     * 2-女
     */
    private SexEnum sex;

    /**
     * 学生年级
     */
    private Integer grade;

    @TableField(exist = false)
    private List<Course> courses;


}
