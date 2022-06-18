package homework.springboothomework.dao;

import homework.springboothomework.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AdminDao {
    //登录
    Integer login(@Param("no")Integer no,@Param("pass") String pass);
    //查询个人信息
    Admin findOneByNo(Integer no);
    //改密码
    boolean updatePass(@Param("no") Integer no, @Param("pass") String pass);
}
