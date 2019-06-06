package com.dingli.javaee.dao;

import com.dingli.javaee.bean.Info;
import com.dingli.javaee.jdbc.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InfoDAOImpl implements InfoDAO{
    @Override
    public void query(Info info) {
        Connection conn = null;
        PreparedStatement pst = null;
        String sql = "select * form user_info";

        try {
            conn = JDBCUtil.getConnection();
            pst = conn.prepareStatement(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
