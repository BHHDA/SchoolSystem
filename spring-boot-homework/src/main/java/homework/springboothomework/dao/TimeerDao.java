package homework.springboothomework.dao;

import homework.springboothomework.pojo.Timeer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Mapper
@Repository
//出入时间表
public interface TimeerDao {
    //添加出校记录
    boolean addOne(Timeer timeer);
    //查询所有
    List<Timeer> findAll();
    //根据记录时间查询
    List<Timeer> findListByTime(Date date);
    //查看学生是否在校
    List<Timeer> findLocal(Integer sno);
    //添加返校记录
    boolean updateOne(Timeer timeer);
}
