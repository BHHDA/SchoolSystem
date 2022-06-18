package homework.springboothomework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import homework.springboothomework.dao.TimeerDao;
import homework.springboothomework.pojo.Timeer;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.TimeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TimeerServiceImpl implements TimeerService {
    @Autowired
    private TimeerDao timeerDao;


    @Override
    public boolean addOne(Timeer timeer) {
        return timeerDao.addOne(timeer);
    }

    @Override
    public PageInfo<Timeer> findAll(Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(timeerDao.findAll());
    }

    @Override
    public PageInfo<Timeer> findListByTime(Date date, Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(timeerDao.findListByTime(date));
    }

    @Override
    public Timeer findLocal(Integer sno) {
        List<Timeer> timeerList=timeerDao.findLocal(sno);
        if(timeerList.size()==0)return null;
        Timeer timeer=timeerList.get(0);
        return timeer;

    }

    @Override
    public boolean updateOne(Timeer timeer) {
        return timeerDao.updateOne(timeer);
    }
}
