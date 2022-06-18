package homework.springboothomework.service.impl;

import homework.springboothomework.dao.SignInDao;
import homework.springboothomework.pojo.SignIn;
import homework.springboothomework.service.SignInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SignInServiceImpl  implements SignInService {
    @Autowired
    private SignInDao signInDao;

    @Override
    public boolean findOneByTimeandSno(Integer sno, Date time) {
        int i=signInDao.findOneByTimeandSno(sno,time);
        if(i>0)return true;
        else
        return false;
    }

    @Override
    public boolean addOne(SignIn signIn) {
        return signInDao.addOne(signIn);
    }
}
