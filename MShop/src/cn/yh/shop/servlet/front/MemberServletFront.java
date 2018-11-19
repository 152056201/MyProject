package cn.yh.shop.servlet.front;

import cn.yh.Utils.MD5;
import cn.yh.Utils.validate.BasePath;
import cn.yh.Utils.validate.ValidateUtils;
import cn.yh.shop.factory.ServiceFrontFactory;
import cn.yh.shop.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "MemberServletFront" ,urlPatterns = "/pages/MemberServletFront/*")
public class MemberServletFront extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = "/pages/errors.jsp";
        String status = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/")+1);
        if(status!=null){
            if("regist".equals(status)){
                path = this.regist(request);
            }
        }
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
    //用户注册
    public String regist(HttpServletRequest request) throws ServletException, IOException{
        String msg = null;//forward.jsp提示信息
        String url = null;//forward.jsp路径
        String mid = request.getParameter("mid");
        String password = request.getParameter("password");
        //必须通过验证才能执行以下功能操作
        if(ValidateUtils.validateEmpty("mid")&&ValidateUtils.validateEmpty("password")){
            Member vo = new Member();
            vo.setMid(mid);
            vo.setPassword(new MD5().GetMD5Code(password));//MD5加密
            vo.setRegdate(new Date());//注册日期为今天
            vo.setPhoto("nophoto.jpg");
            vo.setCode(UUID.randomUUID().toString());//随机生成一个code码；
            vo.setStatus(2);//未激活状态
            try {
                if(ServiceFrontFactory.getIMemberServiceFrontInstance().regist(vo)){
                    msg="注册成功，请进行账户激活";
                    url = "/pages/index.jsp"; //成功页面
                    System.out.println("【邮箱激活】"+ BasePath.getBasePath(request)+
                            "/pages/member_active.jsp？mid="+mid+"&code="+vo.getCode());//跳转到激活页面
                }else {
                    msg="注册失败，请核对信息";
                    url= "/pages/member_regist.jsp";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            msg = "输入的用户信息不正确，请重新输入！";
            url = "pages/member_regist.jsp";//返回注册页；
        }
        request.setAttribute("msg",msg);
        request.setAttribute("url",url);
        return "/pages/forward.jsp";
    }
}
