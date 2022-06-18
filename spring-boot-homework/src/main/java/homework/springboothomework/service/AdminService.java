package homework.springboothomework.service;


import homework.springboothomework.pojo.Admin;
import org.apache.ibatis.annotations.Param;

public interface AdminService {
    //登录
    boolean login(Integer no, String pass);
    //查询个人信息
    Admin findOneByNo(Integer no);
    //改密码
    boolean updatePass(Integer no, String pass);
}
