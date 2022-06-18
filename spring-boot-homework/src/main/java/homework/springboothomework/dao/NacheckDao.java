package homework.springboothomework.dao;

import homework.springboothomework.pojo.Nacheck;
import homework.springboothomework.pojo.Timeer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
//检测更改表
public interface NacheckDao {
    //添加检测更改记录
    boolean addOne(Nacheck nacheck);

    //根据学号查询记录
    Nacheck findOneBySno(Integer sno);
    //根据工号查询记录
    Nacheck findOneByJobno(Integer jobno);
    //查询所有
    List<Nacheck> findAll();
    //根据记录时间查询
    List<Nacheck> findListByTime(Date date);

}
