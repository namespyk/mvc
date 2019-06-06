package com.dingli.javaee.service;

import com.dingli.javaee.bean.Student;
import com.dingli.javaee.bean.param.Pager;
import com.dingli.javaee.bean.param.StuParam;
import com.dingli.javaee.dao.StudentDAO;
import com.dingli.javaee.dao.StudentDAOImpl;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements com.dingli.javaee.service.StudentService {

    private StudentDAO studentDAO = new StudentDAOImpl();

    @Override
    public void insert(Student student) {
        studentDAO.intsert(student);
    }

    @Override
    public List<Student> query(Map<String, Object> whereMap) {
        return studentDAO.query(whereMap);
    }

    @Override
    public void delete(long id) {
        studentDAO.delete(id);
    }

    @Override
    public Pager<Student> query(StuParam param, Pager<Student> pager) {
        return studentDAO.query(param,pager);
    }

    @Override
    public void update(Student s) {
        studentDAO.update(s);
    }
}
