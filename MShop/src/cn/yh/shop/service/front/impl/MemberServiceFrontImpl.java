package cn.yh.shop.service.front.impl;

import cn.yh.shop.dbc.DateBaseConnection;
import cn.yh.shop.factory.DAOFactory;
import cn.yh.shop.service.front.IMemberServiceFont;
import cn.yh.shop.vo.Member;

public class MemberServiceFrontImpl implements IMemberServiceFont {
    DateBaseConnection dbc = new DateBaseConnection();
    @Override
    public boolean regist(Member vo) throws Exception {
        try{
            if(DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).findById(vo.getMid())==null){
                return DAOFactory.getIMemberDAOInstance(this.dbc.getConn()).doCreate(vo);
            }
            return  false;
        }catch (Exception e){
            throw e;
        }finally {
            this.dbc.close();
        }
    }
}
