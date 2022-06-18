package homework.springboothomework.service;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.pojo.Waiting;
import homework.springboothomework.pojo.query.Page;

import java.util.List;

public interface WaitingService {
    //查询所有待测学生
    PageInfo<Waiting> findAll(Page page);
    //添加一个待测学生
    boolean addOne(Waiting waiting);
    //删除待测学生
    boolean deleteOne(Integer sno);
    //模糊查询
    PageInfo<Waiting> findListBySno(String sno,Page page);
}
