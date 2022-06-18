package homework.springboothomework.dao;


import homework.springboothomework.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentDao {
    //超管查询所有学生
    List<Student> findAll();
    //根据学号模糊查询学生信息
    List<Student> findOneBySno(String sno);
    //更新学生健康状态
    boolean updateOneByName(@Param("sno") Integer sno, @Param("healthcode") String healthcode);
    //更新学生信息
    boolean updateOne(Student student);
    //改密码
    boolean updatePass(@Param("sno") Integer sno, @Param("pass") String pass);
    //添加学生
    boolean addOne(Student student);
    //学生登录验证
    Integer login(@Param("sno") Integer sno,@Param("pass") String pass);
    //验证学生姓名
    Student findOne(Integer sno);
    Student loginBySno(Integer sno);
    //删除学生
    boolean deleteOne(Integer sno);
}
