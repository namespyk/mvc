package com.dingli.javaee.dao;

import com.dingli.javaee.bean.Student;
import com.dingli.javaee.bean.param.Pager;
import com.dingli.javaee.bean.param.StuParam;

import java.util.List;
import java.util.Map;

public interface StudentDAO {

    void intsert(Student student);

    List<Student> query(Map<String,Object> whereMap);

    void delete(long id);

    Pager<Student> query(StuParam param, Pager<Student> pager);

    void update(Student s);
}
