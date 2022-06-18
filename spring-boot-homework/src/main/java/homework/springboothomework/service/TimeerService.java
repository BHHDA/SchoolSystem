package homework.springboothomework.service;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.pojo.Timeer;
import homework.springboothomework.pojo.query.Page;

import java.util.Date;
import java.util.List;

public interface TimeerService {
    //添加
    boolean addOne(Timeer timeer);
    //查询所有
    PageInfo<Timeer> findAll(Page page);
    //根据记录时间查询
    PageInfo<Timeer> findListByTime(Date date,Page page);
    //查看学生最近的出入记录
    Timeer findLocal(Integer sno);
    //添加返校记录
    boolean updateOne(Timeer timeer);
}
