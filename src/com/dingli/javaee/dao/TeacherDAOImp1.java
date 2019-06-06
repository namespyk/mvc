package com.dingli.javaee.dao;

import com.dingli.javaee.bean.Teacher;
import com.dingli.javaee.bean.param.Pager;
import com.dingli.javaee.bean.param.TeaParam;
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

public class TeacherDAOImp1 implements TeacherDAO{
    @Override
    public void intsert(Teacher teacher) {
        Connection conn = null;
        PreparedStatement pst = null;
        String sql = "insert into tab_teacher(`name`,age,sex,`college`,`subject`)" +
                "values(?,?,?,?,?)";
        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);

            pst.setString(1, teacher.getName());
            pst.setInt(2, teacher.getAge());
            pst.setInt(3, teacher.getSex());
            pst.setString(4, teacher.getCollege());
            pst.setString(5, teacher.getSubject());

            pst.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JDBCUtil.close(conn,pst,null);
        }
    }

//    @Override
//    public List<Teacher> query(Map<String, Object> whereMap) {
//
//        Connection conn = null;
//        PreparedStatement psd = null;
//        ResultSet rs = null;
//
//
//        try {
//            conn = JDBCUtil.getConnection();
//            String sql = initSQL(whereMap);
//            System.out.println("================");
//            System.out.println(sql);
//            System.out.println(whereMap);
//            System.out.println("================");
//            psd = conn.prepareStatement(sql);
//
////            psd.setString(1,(String)whereMap.get("name"));
////            psd.setInt(2,Integer.parseInt((String) whereMap.get("ageS")));
////            psd.setInt(3,Integer.parseInt((String) whereMap.get("ageE")));
//
//            rs = psd.executeQuery();
//            List<Teacher> list = new ArrayList<>();
//            while (rs.next()){
//                Teacher s = ObjUtil.getInstance(rs,Teacher.class);
//                list.add(s);
//            }
//
//            return list;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            JDBCUtil.close(conn,psd,rs);
//        }
//
//        return null;
//    }

//    private String initSQL(Map<String, Object> whereMap) {
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("select * from tab_teacher");
//        return sb.toString();
//    }

    @Override
    public void delete(long id) {
        Connection conn = null;
        PreparedStatement psd = null;

        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "delete from tab_teacher where id = ?";
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

    private String initSql(TeaParam sp,Pager<Teacher> pager){
        return new SQL(){{
            if(pager == null) {
                SELECT("count(s.id) as total");
            }else{
                SELECT("s.*");
            }
            FROM("tab_teacher s");
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
    public List<Teacher> queryPageList(TeaParam sp,Pager<Teacher> pager){
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
            List<Teacher> list = new ArrayList<>();
            while (rs.next()){
                Teacher s = ObjUtil.getInstance(rs,Teacher.class);
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


    private int queryCount(TeaParam sp){
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
    public Pager<Teacher> query(TeaParam sp,Pager<Teacher> pager) {
        pager.setTotal(queryCount(sp));
        pager.setList(queryPageList(sp,pager));
        return pager;
    }

    @Override
    public void update(Teacher teacher) {
        Connection conn = null;
        PreparedStatement psd = null;

        try {
            conn = JDBCUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "update tab_teacher set name=?,age = ?," +
                    "sex = ?,college = ?,subject = ? where id =  ?";
            psd = conn.prepareStatement(sql);

            psd.setString(1,teacher.getName());
            psd.setInt(2,teacher.getAge());
            psd.setInt(3,teacher.getSex());
            psd.setString(4,teacher.getCollege());
            psd.setString(5,teacher.getSubject());
            psd.setLong(6, teacher.getId());


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
