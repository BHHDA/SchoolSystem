package homework.springboothomework.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import homework.springboothomework.dao.StudentDao;
import homework.springboothomework.pojo.Student;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao dao;


    @Override
    public PageInfo<Student> findAll(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return new PageInfo<>(dao.findAll());
    }

    @Override
    public PageInfo<Student> findOneBySno(String sno,Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        return new PageInfo<Student>(dao.findOneBySno(sno));

    }

    @Override
    public boolean updatePass(Integer sno, String pass) {
        return dao.updatePass(sno,pass);
    }

    @Override
    public boolean updateOne(Student student) {
        return dao.updateOne(student);
    }

    @Override
    public boolean updateOneByName(Integer sno, String healthcode) {
        return dao.updateOneByName(sno, healthcode);
    }

    @Override
    public boolean addOne(Student student) {
        return dao.addOne(student);
    }

    @Override
    public boolean login(Integer sno, String pass) {
        int i=dao.login(sno,pass);
        if(i>0)return true;
        else  return false;
    }

    @Override
    public Student findOne(Integer sno) {
        return dao.findOne(sno);
    }

    @Override
    public Student loginBySno(Integer sno) {
        return dao.loginBySno(sno);
    }

    @Override
    public boolean deleteOne(Integer sno) {
        return dao.deleteOne(sno);
    }
}
