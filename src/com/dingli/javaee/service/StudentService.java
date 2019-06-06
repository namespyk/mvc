package com.dingli.javaee.service;

import com.dingli.javaee.bean.Student;
import com.dingli.javaee.bean.param.Pager;
import com.dingli.javaee.bean.param.StuParam;

import java.util.List;
import java.util.Map;

public interface StudentService {

    /**
     * 添加学生数据
     * @param student
     */
    void insert(Student student);

    List<Student> query(Map<String,Object> whereMap);

    Pager<Student> query(StuParam param, Pager<Student> pager);

    void delete(long id);

    void update(Student s);
}
