package homework.springboothomework.service;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.pojo.Doorer;
import homework.springboothomework.pojo.query.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DoorerService {

    //添加
    boolean addOne(Doorer doorer);
    //修改
    //更新一条记录
    boolean updateOne(Doorer doorer);
    //修改密码
    boolean updatePass(Integer jno,String pass);
    //删除
    //管理员删除值班人员
    boolean deleteOne(Integer jno);
    //查询
    //登录
     boolean login(Integer no, String pass);
    Doorer loginByJno(Integer sno);
    //查询所有工人信息
    PageInfo<Doorer> findAll(Page page);
    //根据工号模糊查询员工
    PageInfo<Doorer> findOneByJno(String jno,Page page);
    //通过工号查名字
    String getNameByJno(Integer jno);
}
