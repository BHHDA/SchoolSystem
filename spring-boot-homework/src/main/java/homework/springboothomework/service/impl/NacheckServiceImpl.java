package homework.springboothomework.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import homework.springboothomework.dao.NacheckDao;
import homework.springboothomework.pojo.Nacheck;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.NacheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NacheckServiceImpl implements NacheckService {
    @Autowired
private NacheckDao nacheckDao;
    @Override
    public boolean addOne(Nacheck nacheck) {
        return nacheckDao.addOne(nacheck);
    }

    @Override
    public Nacheck findOneBySno(Integer sno) {
        return nacheckDao.findOneBySno(sno);
    }

    @Override
    public Nacheck findOneByJobno(Integer jobno) {
        return nacheckDao.findOneByJobno(jobno);
    }

    @Override
    public PageInfo<Nacheck> findAll(Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(nacheckDao.findAll());
    }

    @Override
    public PageInfo<Nacheck> findListByTime(Date date, Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(nacheckDao.findListByTime(date));
    }
}
