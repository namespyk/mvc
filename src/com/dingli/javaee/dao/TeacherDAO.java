package com.dingli.javaee.dao;

import com.dingli.javaee.bean.Teacher;
import com.dingli.javaee.bean.param.Pager;
import com.dingli.javaee.bean.param.TeaParam;

import java.util.List;
import java.util.Map;

public interface TeacherDAO {
    void intsert(Teacher teacher);

//    List<Teacher> query(Map<String,Object> whereMap);

    void delete(long id);

    Pager<Teacher> query(TeaParam param,Pager<Teacher> pager);

    void update(Teacher t);
}
