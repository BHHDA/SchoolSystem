package homework.springboothomework.dao;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.pojo.Doorer;
import homework.springboothomework.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
//值班人员表
public interface DoorerDao {
    //添加
    boolean addOne(Doorer doorer);
    //修改
    //修改密码
    boolean updatePass(@Param("jno") Integer jno, @Param("pass") String pass);
    //更新一条记录
    boolean updateOne(Doorer doorer);
    //删除
    //管理员删除值班人员
    boolean deleteOne(Integer jno);
    //查询
    //登录
    Integer login(@Param("jno")Integer no,@Param("pass") String pass);
    Doorer loginByJno(Integer jno);

    //查询所有工人信息
    List<Doorer> findAll();
    //根据工号模糊查询员工
    List<Doorer> findOneByJno(String jno);
    //通过工号查名字
    String getNameByJno(Integer jno);
}
