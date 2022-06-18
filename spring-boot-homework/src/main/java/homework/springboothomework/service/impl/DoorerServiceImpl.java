package homework.springboothomework.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import homework.springboothomework.dao.DoorerDao;
import homework.springboothomework.pojo.Doorer;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.DoorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoorerServiceImpl implements DoorerService {

    @Autowired
    private DoorerDao doorerDao;

    @Override
    public boolean addOne(Doorer doorer) {
        return doorerDao.addOne(doorer);
    }

    @Override
    public boolean updateOne(Doorer doorer) {
        return doorerDao.updateOne(doorer);
    }

    @Override
    public boolean updatePass(Integer jno, String pass) {
        return doorerDao.updatePass(jno,pass);
    }

    @Override
    public boolean deleteOne(Integer jno) {
        return doorerDao.deleteOne(jno);
    }

    @Override
    public boolean login(Integer no, String pass) {

        int i = doorerDao.login(no,pass);
        if (i>0)
            return true;
        else
            return false;
    }

    @Override
    public Doorer loginByJno(Integer jno) {
        return doorerDao.loginByJno(jno);
    }

    @Override
    public PageInfo<Doorer> findAll(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return new PageInfo<>(doorerDao.findAll());
    }

    @Override
    public PageInfo<Doorer> findOneByJno(String jno,Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return new PageInfo<Doorer>(doorerDao.findOneByJno(jno));
    }
    //通过工号查名字
    public String getNameByJno(Integer jno){
        return doorerDao.getNameByJno(jno);
    }
}
