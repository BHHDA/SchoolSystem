package homework.springboothomework.dao;

import homework.springboothomework.pojo.SignIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Mapper
@Repository
public interface SignInDao {
    //查询学生当天是否有健康上报的记录
    int findOneByTimeandSno(@Param("sno")Integer sno,@Param("time") Date time);
    //学生健康上报
    boolean addOne(SignIn signIn);

}
