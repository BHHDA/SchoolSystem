package homework.springboothomework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import homework.springboothomework.dao.WaitingDao;
import homework.springboothomework.pojo.Waiting;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.WaitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaitingServiceImpl implements WaitingService {
@Autowired
private WaitingDao waitingDao;
    @Override
    public PageInfo<Waiting> findAll(Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(waitingDao.findAll());
    }

    @Override
    public boolean addOne(Waiting waiting) {
        return waitingDao.addOne(waiting);
    }

    @Override
    public boolean deleteOne(Integer sno) {
        return waitingDao.deleteOne(sno);
    }

    @Override
    public PageInfo<Waiting> findListBySno(String sno, Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(waitingDao.findListBySno(sno));
    }
}
