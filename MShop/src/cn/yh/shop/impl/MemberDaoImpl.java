package cn.yh.shop.impl;

import cn.yh.Utils.dao.AbstractDAOImpl;
import cn.yh.shop.dao.IMemberDAO;
import cn.yh.shop.vo.Member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * IMemberDAO接口的实现类
 */
public class MemberDaoImpl extends AbstractDAOImpl implements IMemberDAO {
    public MemberDaoImpl(Connection conn){
        super(conn);
    }
    @Override
    public boolean doCreate(Member vo) throws Exception {
        String sql = " insert into member(mid,password,status,code,regdate,photo) values(?,?,?,?,?,?) ";
        this.ps = super.conn.prepareStatement(sql);
        this.ps.setString(1,vo.getMid());
        this.ps.setString(2,vo.getPassword());
        this.ps.setInt(3,vo.getStatus());
        this.ps.setString(4,vo.getCode());
        this.ps.setTimestamp(5,new Timestamp(vo.getRegdate().getTime()));
        this.ps.setString(6,vo.getPhoto());
        return super.ps.executeUpdate()>0;
    }

    @Override
    public boolean doUpdate(Member vo) throws Exception {
        return false;
    }

    @Override
    public boolean doRemove(Set<String> ids) throws Exception {
        return false;
    }

    @Override
    public Member findById(String id) throws Exception {
        Member vo = null;
        String sql = " select mid,name,phone,address,code,status,regdate,photo from member where mid=? ";
        this.ps = super.conn.prepareStatement(sql);
        super.ps.setString(1,id);
        ResultSet rs = super.ps.executeQuery();
        while(rs.next()){
            vo = new Member();
            vo.setMid(rs.getString(1));
            vo.setName(rs.getString(2));
            vo.setPhone(rs.getString(3));
            vo.setAddress(rs.getString(4));
            vo.setCode(rs.getString(5));
            vo.setStatus(rs.getInt(6));
            vo.setRegdate(rs.getTimestamp(7));
            vo.setPhoto(rs.getString(8));
        }
        return vo;
    }

    @Override
    public List<Member> findAll() throws Exception {
        return null;
    }

    @Override
    public List<Member> findSplit(Integer currentpage, Integer linesize, String column, String keyword) throws Exception {
        return null;
    }

    @Override
    public Integer getAllCount(String column, String keyword) throws Exception {
        return null;
    }
}
