package homework.springboothomework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import homework.springboothomework.dao.PlanDao;
import homework.springboothomework.pojo.Plan;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.PlanService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanDao planDao;
    @Override
    public boolean addOne(Plan plan) {
        return planDao.addOne(plan);
    }

    @Override
    public boolean deleteOne(Integer no) {
        return planDao.deleteOne(no);
    }

    @Override
    public PageInfo<Plan> findListByTime(Date time,Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(planDao.findListByTime(time));
    }

    @Override
    public PageInfo<Plan> findListByTimeAndD(Date time, Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(planDao.findListByTimeAndD(time));
    }

    @Override
    public PageInfo<Plan> findListByTimeAndN(Date time, Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(planDao.findListByTimeAndN(time));
    }

    @Override
    public PageInfo<Plan> findListByJno(Integer jno,Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(planDao.findListByJno(jno));
    }

    @Override
    public PageInfo<Plan> findListByJobnoAndTIme(Integer jobno, Date time,Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(planDao.findListByJT(jobno,time));
    }

    @Override
    public Plan findOneByNo(Integer no) {
        return planDao.findOneByNo(no);
    }

    @Override
    public boolean updateOneByNo(Plan plan) {
        return planDao.updateOneByNo(plan);
    }

    @Override
    public PageInfo<Plan> findAll(Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<Plan>(planDao.findAll());
    }

    @Override
    public PageInfo<Plan> findAllDoorer(Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<Plan>(planDao.findAllDoorer());
    }

    @Override
    public PageInfo<Plan> findAllNucleictester(Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<Plan>(planDao.findAllNucleictester());
    }

    @Override
    public boolean findOneByJobno(Integer jobno, Date time) {
        List planList=planDao.findOneByJobno(jobno, time);
        if(planList.size()>0)return true;
        else
        return false;
    }
    @Override
    //获取值班人员值班地区
    public Plan findArea(@Param("jobno") Integer jobno, @Param("time") Date time){
        List<Plan> planList=planDao.findOneByJobno(jobno, time);
        Plan plan=planList.get(0);
        return plan;
    }
}
