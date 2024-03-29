package com.group.bodyBuilding.dao.impl;

import com.group.bodyBuilding.dao.AuthorityDao;
import com.group.bodyBuilding.dao.ConnectionDatabase;
import com.group.bodyBuilding.vo.Authority;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AuthorityDaoImpl implements AuthorityDao {
    public int queryById(String id) {
        return 1;
//        Connection conn = new ConnectionDatabase().getConnnection();
//        PreparedStatement st = null;
//        Authority authority = new Authority();
//        ResultSet rs = null;
//        String sql = "SELECT id,authority FROM authority WHERE id=?";
//        try {
//            st = conn.prepareStatement(sql);
//            st.setString(1, id);
//            rs = st.executeQuery();
//            if (rs.next()) {
//                authority.setAuthority(rs.getInt("authority"));
//            }
//            else {
//                authority.setAuthority(0);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (st != null) {
//                    st.close();
//                }
//                if (conn != null) {
//                    conn.close();
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return authority.getAuthority();
    }

    public boolean add(Authority authority) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "INSERT INTO authority (id,authority) VALUE (?,?)";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, authority.getId());
            st.setInt(2, authority.getAuthority());
            int i = st.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    public boolean del(String id) {
        boolean flag = false;
        Connection conn = new ConnectionDatabase().getConnnection();
        PreparedStatement st = null;
        String sql = "DELETE FROM authority WHERE id=?";
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            int i = st.executeUpdate();
            if (i == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }
}
