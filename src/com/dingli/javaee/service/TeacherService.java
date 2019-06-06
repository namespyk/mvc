package com.dingli.javaee.service;

import com.dingli.javaee.bean.Teacher;
import com.dingli.javaee.bean.param.Pager;
import com.dingli.javaee.bean.param.TeaParam;

import java.util.List;
import java.util.Map;

public interface TeacherService {
    void insert(Teacher teacher);

//    List<Teacher> query(Map<String,Object> whereMap);

    Pager<Teacher> query(TeaParam param, Pager<Teacher> pager);

    void delete(long id);

    void update(Teacher t);
}
