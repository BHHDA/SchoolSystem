package homework.springboothomework.service;


import com.github.pagehelper.PageInfo;
import homework.springboothomework.pojo.Student;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.pojo.query.StudentQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    //超管查询所有学生
    PageInfo<Student> findAll(Page page);
    //根据学号查询学生信息
    PageInfo<Student> findOneBySno(String sno,Page page);
    //改密码
    boolean updatePass(@Param("sno") Integer sno, @Param("pass") String pass);
    //更新学生信息
    boolean updateOne(Student student);
    //更新学生健康状态
    boolean updateOneByName( Integer sno, String healthcode);
    //添加学生
    boolean addOne(Student student);
    //学生登录验证
    boolean login(Integer sno,String pass);
    //验证学生姓名
    Student findOne(Integer sno);
    Student loginBySno(Integer sno);
    //删除学生
    boolean deleteOne(Integer sno);
}
