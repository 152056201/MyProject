package cn.yh.Utils.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 实现MemberDaoImpl操作的公共类
 */
public abstract class AbstractDAOImpl {
    protected Connection conn;
    protected PreparedStatement ps;
    public AbstractDAOImpl(Connection conn){
        this.conn = conn;
    }

    /**
     * 实现删除操作 属于彻底删除
     * @param table 删除表名称
     * @param column 删除列名称
     * @param ids 所有id数据 使用set集合防止重复
     * @return删除成功返回true ,失败返回false
     * @throws Exception
     */
    public boolean removeHandle(String table, String column, Set<?>ids) throws  Exception{
        if(ids.size()==0){//表示没有任何数据
            return false;
        }
        Iterator<?> ite = ids.iterator();
        StringBuffer sql = new StringBuffer();
        sql.append(" delete from ").append(table).append(" where ").append(column).append(" in( ");
        while (ite.hasNext()){
            sql.append(ite.next()).append(",");
        }
        sql.delete(sql.length()-1,sql.length()).append(")");
        this.ps = this.conn.prepareStatement(sql.toString());
        return  this.ps.executeUpdate()==ids.size();
    }

    /**
     * 负责统计数据量
     * @param column 查询数据列
     * @param keyword 查询关键字
     * @return返回指定表数据量，如果没有返回0
     * @throws Exception
     */
    public Integer countHandle(String table,String column,String keyword) throws  Exception{
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(*) from ").append(table).append(" where ").append(column).append(" like ? ");
        this.ps = this.conn.prepareStatement(sql.toString());
        this.ps.setString(1,"%"+keyword+"%");
        ResultSet rs = this.ps.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }
        return  0;
    }
}
