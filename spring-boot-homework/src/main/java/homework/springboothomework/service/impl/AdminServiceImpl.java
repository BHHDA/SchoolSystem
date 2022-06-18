package homework.springboothomework.service.impl;

import homework.springboothomework.dao.AdminDao;
import homework.springboothomework.pojo.Admin;
import homework.springboothomework.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public boolean login(Integer no, String pass) {
        int i = adminDao.login(no,pass);
        if (i>0)
            return true;
        else
            return false;
    }

    @Override
    public Admin findOneByNo(Integer no) {
        return adminDao.findOneByNo(no);
    }

    @Override
    public boolean updatePass(Integer no, String pass) {
        return adminDao.updatePass(no, pass);
    }
}
