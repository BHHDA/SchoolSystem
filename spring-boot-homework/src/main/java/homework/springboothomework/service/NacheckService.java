package homework.springboothomework.service;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.pojo.Nacheck;
import homework.springboothomework.pojo.query.Page;

import java.util.Date;
import java.util.List;

public interface NacheckService {
    //添加检测更改记录
    boolean addOne(Nacheck nacheck);

    //根据学号查询记录
    Nacheck findOneBySno(Integer sno);
    //根据工号查询记录
    Nacheck findOneByJobno(Integer jobno);
    //查询所有
    PageInfo<Nacheck> findAll(Page page);
    //根据记录时间查询
    PageInfo<Nacheck> findListByTime(Date date,Page page);
}
