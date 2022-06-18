package homework.springboothomework.dao;

import homework.springboothomework.pojo.Doorer;
import homework.springboothomework.pojo.Nucleictester;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
//核酸区域检测人员表
public interface NucleictesterDao {
    //添加
    boolean addOne(Nucleictester nucleictester);
    //修改
    //更新一条记录
    boolean updateOne(Nucleictester nucleictester);
    //修改密码
    boolean updatePass(@Param("jno") Integer jno, @Param("pass") String pass);
    //删除
    //管理员删除值班人员
    boolean deleteOne(Integer jno);
    //查询
    //登录
    Integer login(@Param("jno")Integer no,@Param("pass") String pass);
    Nucleictester loginByJno(Integer jno);
    //查询所有工人信息
    List<Nucleictester> findAll();
    //根据工号模糊查询员工
    List<Nucleictester> findOneByJno(String jno);
    //通过工号查名字
    String getNameByJno(Integer jno);
}
