package homework.springboothomework.service;

import homework.springboothomework.pojo.SignIn;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface SignInService {
    //查询学生当天是否有健康上报的记录
    boolean findOneByTimeandSno(Integer sno,Date time);
    //学生健康上报
    boolean addOne(SignIn signIn);
}
