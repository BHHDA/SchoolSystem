package homework.springboothomework.service;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.pojo.Plan;
import homework.springboothomework.pojo.query.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface PlanService {
    //管理员添加一条安排记录
    boolean addOne(Plan plan);
    //管理员删除一条安排记录
    boolean deleteOne(Integer no);
    //查询当天安排记录
    PageInfo<Plan> findListByTime(Date time,Page page);
    //查询当天值班安排记录
    PageInfo<Plan> findListByTimeAndD(Date time,Page page);
    //查询当天核检安排记录
    PageInfo<Plan> findListByTimeAndN(Date time,Page page);
    //查询员工安排记录
    PageInfo<Plan> findListByJno(Integer jno,Page page);
    //员工查询自己当天的安排记录
    PageInfo<Plan> findListByJobnoAndTIme(Integer jobno,Date time,Page page);

    //查询指定记录
    Plan findOneByNo(Integer no);
    //更新指定记录
    boolean updateOneByNo(Plan plan);
    //查询所有记录
    PageInfo<Plan> findAll(Page page);
    //查询所有值班记录
    PageInfo<Plan> findAllDoorer(Page page);
    //查询所有核检记录
    PageInfo<Plan> findAllNucleictester(Page page);
    //值班人员或核酸检测人员登录验证
    boolean findOneByJobno(@Param("jobno") Integer jobno, @Param("time") Date time);
    //获取值班人员值班地区
    Plan findArea(@Param("jobno") Integer jobno, @Param("time") Date time);
}
