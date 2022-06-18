package homework.springboothomework.dao;

import homework.springboothomework.pojo.Waiting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface WaitingDao {
    //查询所有待测学生
    List<Waiting> findAll();
    //添加一个待测学生
    boolean addOne(Waiting waiting);
    //删除待测学生
    boolean deleteOne(Integer sno);
    //模糊查询
    List<Waiting> findListBySno(String sno);
}
