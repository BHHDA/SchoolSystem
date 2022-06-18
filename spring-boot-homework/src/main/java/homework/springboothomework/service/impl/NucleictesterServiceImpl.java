package homework.springboothomework.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import homework.springboothomework.dao.NucleictesterDao;
import homework.springboothomework.pojo.Doorer;
import homework.springboothomework.pojo.Nucleictester;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.NucleictesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NucleictesterServiceImpl implements NucleictesterService {
    @Autowired
    NucleictesterDao nucleictesterDao;
    @Override
    public boolean addOne(Nucleictester nucleictester) {
        return nucleictesterDao.addOne(nucleictester);
    }

    @Override
    public boolean updateOne(Nucleictester nucleictester) {
        return nucleictesterDao.updateOne(nucleictester);
    }

    @Override
    public boolean updatePass(Integer jno, String pass) {
        return nucleictesterDao.updatePass(jno, pass);
    }

    @Override
    public boolean deleteOne(Integer jno) {
        return nucleictesterDao.deleteOne(jno);
    }

    @Override
    public boolean login(Integer no, String pass) {
        int i = nucleictesterDao.login(no,pass);
        if (i>0)
            return true;
        else
            return false;
    }

    @Override
    public Nucleictester loginByJno(Integer jno) {
        return nucleictesterDao.loginByJno(jno);
    }

    @Override
    public PageInfo<Nucleictester> findAll(Page page) {
        PageHelper.startPage(page.getPageNum(),page.getPageSize());
        return new PageInfo<>(nucleictesterDao.findAll());
    }
    @Override
    public PageInfo<Nucleictester> findOneByJno(String jno, Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return new PageInfo<Nucleictester>(nucleictesterDao.findOneByJno(jno));
    }

    @Override
    public String getNameByJno(Integer jno) {
        return nucleictesterDao.getNameByJno(jno);
    }
}
