package com.dingli.javaee.dao;

import com.dingli.javaee.bean.Student;
import com.dingli.javaee.bean.param.Pager;
import com.dingli.javaee.bean.param.StuParam;
import com.dingli.javaee.jdbc.JDBCUtil;
import com.dingli.javaee.jdbc.ObjUtil;
import com.dingli.javaee.jdbc.SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentDAOImpl implements StudentDAO{

    @Override
    public void intsert(Student student) {

        Connection conn = null;
        PreparedStatement psd = null;

        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into tab_student(`name`,`age`,`sex`,`favs`,`edu`,`desc`) " +
                    "values(?,?,?,?,?,?)";
            psd = conn.prepareStatement(sql);

            psd.setString(1,student.getName());
            psd.setInt(2,student.getAge());
            psd.setInt(3,student.getSex());
            psd.setString(4,student.getFavs());
            psd.setInt(5,student.getEdu());
            psd.setString(6,student.getDesc());

            psd.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JDBCUtil.close(conn,psd,null);
        }

    }

    @Override
    public List<Student> query(Map<String, Object> whereMap) {

        Connection conn = null;
        PreparedStatement psd = null;
        ResultSet rs = null;


        try {
            conn = JDBCUtil.getConnection();
            String sql = initSQL(whereMap);
            System.out.println("================");
            System.out.println(sql);
            System.out.println(whereMap);
            System.out.println("================");
            psd = conn.prepareStatement(sql);

//            psd.setString(1,(String)whereMap.get("name"));
//            psd.setInt(2,Integer.parseInt((String) whereMap.get("ageS")));
//            psd.setInt(3,Integer.parseInt((String) whereMap.get("ageE")));

            rs = psd.executeQuery();
            List<Student> list = new ArrayList<>();
            while (rs.next()){
                Student s = ObjUtil.getInstance(rs,Student.class);
                list.add(s);
            }

            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,psd,rs);
        }

        return null;
    }

    private String initSQL(Map<String, Object> whereMap) {

        StringBuilder sb = new StringBuilder();
        sb.append("select * from tab_student");
//        sb.append(" where name like ? and age >= ? and age <= ?");
        return sb.toString();
    }

    @Override
    public void delete(long id) {
        Connection conn = null;
        PreparedStatement psd = null;

        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from tab_student where id = ?";
            psd = conn.prepareStatement(sql);

            psd.setLong(1,id);

            psd.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JDBCUtil.close(conn,psd,null);
        }
    }

    private String initSql(StuParam sp,Pager<Student> pager){
        return new SQL(){{
            if(pager == null) {
                SELECT("count(s.id) as total");
            }else{
                SELECT("s.*");
            }
            FROM("tab_student s");
            if(sp.getName() != null && !"".equals(sp.getName())){
                WHERE("s.name like ?");
            }
            if(sp.getStart() != null){
                WHERE("s.age >= ?");
            }
            if(sp.getEnd() != null){
                WHERE("s.age <= ?");
            }

        }}.toString();

    }

    /**
     * 查询当前页的数据
     * @param sp
     * @return
     */
    public List<Student> queryPageList(StuParam sp,Pager<Student> pager){
        String querySql = initSql(sp,pager) + " LIMIT ?,?";
        System.out.println(querySql);

        Connection conn = null;
        PreparedStatement psd = null;
        ResultSet rs = null;


        try {
            conn = JDBCUtil.getConnection();
            psd = conn.prepareStatement(querySql);

            int index = 1;
            if(sp.getName() != null && !"".equals(sp.getName())){
                psd.setString(index++,"%"+sp.getName()+"%");
            }
            if(sp.getStart() != null){
                psd.setInt(index++,sp.getStart());
            }
            if(sp.getEnd() != null){
                psd.setInt(index++,sp.getEnd());
            }
            psd.setInt(index++,pager.getStart());
            psd.setInt(index++,pager.getPageSize());

            rs = psd.executeQuery();
            List<Student> list = new ArrayList<>();
            while (rs.next()){
                Student s = ObjUtil.getInstance(rs,Student.class);
                list.add(s);
            }

            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,psd,rs);
        }

        return null;
    }


    private int queryCount(StuParam sp){
        String sql = initSql(sp,null);
        System.out.println(sql);

        Connection conn = null;
        PreparedStatement psd = null;
        ResultSet rs = null;


        try {
            conn = JDBCUtil.getConnection();
            psd = conn.prepareStatement(sql);

            int index = 1;
            if(sp.getName() != null && !"".equals(sp.getName())){
                psd.setString(index++,"%"+sp.getName()+"%");
            }
            if(sp.getStart() != null){
                psd.setInt(index++,sp.getStart());
            }
            if(sp.getEnd() != null){
                psd.setInt(index++,sp.getEnd());
            }

            rs = psd.executeQuery();
            rs.next();

            return rs.getInt("total");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,psd,rs);
        }

        return 0;
    }

    @Override
    public Pager<Student> query(StuParam sp,Pager<Student> pager) {
        pager.setTotal(queryCount(sp));
        pager.setList(queryPageList(sp,pager));
        return pager;
    }

    @Override
    public void update(Student student) {
        Connection conn = null;
        PreparedStatement psd = null;

        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "update tab_student set name=?,age = ?," +
                    "sex = ?,favs = ?,edu = ?,`desc` = ? where id =  ?";
            psd = conn.prepareStatement(sql);

            psd.setString(1,student.getName());
            psd.setInt(2,student.getAge());
            psd.setInt(3,student.getSex());
            psd.setString(4,student.getFavs());
            psd.setInt(5,student.getEdu());
            psd.setString(6,student.getDesc());
            psd.setLong(7,student.getId());

            psd.executeUpdate();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JDBCUtil.close(conn,psd,null);
        }
    }
}
