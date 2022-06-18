package homework.springboothomework.dao;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.pojo.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
//人员安排表
public interface PlanDao {
    //管理员添加一条安排记录
    boolean addOne(Plan plan);
    //管理员删除一条安排记录
    boolean deleteOne(Integer no);
    //查询当天安排记录
    List<Plan> findListByTime(Date time);
    //查询当天值班安排记录
    List<Plan> findListByTimeAndD(Date time);
    //查询当天核检安排记录
    List<Plan> findListByTimeAndN(Date time);
    //查询员工安排记录
    List<Plan> findListByJno(Integer jno);
    //员工查询自己指定当天的安排记录
    List<Plan> findListByJT(@Param("jobno") Integer jobno, @Param("time") Date time);
    //查询指定记录
    Plan findOneByNo(Integer no);
    //更新指定记录
    boolean updateOneByNo(Plan plan);
    //查询所有记录
    List<Plan> findAll();
    //查询所有值班记录
    List<Plan> findAllDoorer();
    //查询所有核检记录
    List<Plan> findAllNucleictester();
    //值班人员或核酸检测人员登录验证
    List<Plan> findOneByJobno(@Param("jobno") Integer jobno, @Param("time") Date time);
}
