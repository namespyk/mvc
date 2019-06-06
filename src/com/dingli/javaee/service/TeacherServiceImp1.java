package com.dingli.javaee.service;

import com.dingli.javaee.bean.Teacher;
import com.dingli.javaee.bean.param.Pager;
import com.dingli.javaee.bean.param.TeaParam;
import com.dingli.javaee.dao.TeacherDAO;
import com.dingli.javaee.dao.TeacherDAOImp1;

import java.util.List;
import java.util.Map;

public class TeacherServiceImp1 implements TeacherService{
    private TeacherDAO teacherDAO = new TeacherDAOImp1();

    @Override
    public void insert(Teacher teacher) {
        teacherDAO.intsert(teacher);
    }

//    @Override
//    public List<Teacher> query(Map<String, Object> whereMap) {
//        return teacherDAO.query(whereMap);
//    }

    @Override
    public Pager<Teacher> query(TeaParam param, Pager<Teacher> pager) {
        return teacherDAO.query(param,pager);
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(Teacher t) {
        teacherDAO.update(t);
    }
}
