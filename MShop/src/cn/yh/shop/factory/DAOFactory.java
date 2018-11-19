package cn.yh.shop.factory;

import cn.yh.shop.dao.IMemberDAO;
import cn.yh.shop.impl.MemberDaoImpl;

import java.sql.Connection;

public class DAOFactory {
    public static IMemberDAO getIMemberDAOInstance(Connection conn){
            return new MemberDaoImpl(conn);
    }
}
