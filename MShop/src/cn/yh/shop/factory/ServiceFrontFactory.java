package cn.yh.shop.factory;

import cn.yh.shop.service.front.IMemberServiceFont;
import cn.yh.shop.service.front.impl.MemberServiceFrontImpl;

public class ServiceFrontFactory {
    public static IMemberServiceFont getIMemberServiceFrontInstance(){
        return new MemberServiceFrontImpl();
    }
}
