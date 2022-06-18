package homework.springboothomework.service;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.pojo.Doorer;
import homework.springboothomework.pojo.Nucleictester;
import homework.springboothomework.pojo.query.Page;


import java.util.List;

public interface NucleictesterService {
    //添加
    boolean addOne(Nucleictester nucleictester);
    //修改
    //更新一条记录
    boolean updateOne(Nucleictester nucleictester);
//修改密码
    boolean updatePass( Integer jno,  String pass);
    //删除
//管理员删除值班人员
    boolean deleteOne(Integer jno);
    //查询
//登录
    boolean login(Integer no, String pass);
    Nucleictester loginByJno(Integer sno);
    //查询所有工人信息
    PageInfo<Nucleictester> findAll(Page page);
    //根据工号模糊查询员工
    PageInfo<Nucleictester> findOneByJno(String jno,Page page);
    //通过工号查名字
    String getNameByJno(Integer jno);
}
