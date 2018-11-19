package cn.yh.shop.service.front;

import cn.yh.shop.vo.Member;

public interface IMemberServiceFont {
    /**
     * 将调用IMemberDAO中的findByID()判断注册ID是否存在
     * 将调用IMemberDAO中的doCreate()保存基本信息
     * @param vo 包含注册信息的vo对象
     * @return
     * @throws Exception
     */
    public boolean regist(Member vo) throws Exception;
}
