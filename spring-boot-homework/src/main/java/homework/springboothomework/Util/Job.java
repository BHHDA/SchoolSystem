package homework.springboothomework.Util;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.pojo.Student;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Job {
    @Autowired
    StudentService studentService;

    @Scheduled(cron="0 0 0 * * ?")
    public void cronJob(){
        PageInfo<Student> studentPageInfo=studentService.findAll(new Page(1,999));
        for(int i=studentPageInfo.getPageNum();i<=studentPageInfo.getPages();i++){
            studentPageInfo.setPageNum(i);
            List<Student> students=studentPageInfo.getList();
            for (Student student : students) {
                if(student.getClockin().equals("已提交")){
                    System.out.println(student.getSno());
                    student.setClockin("未提交");
                    studentService.updateOne(student);
                }
            }
        }

        System.out.println("执行定时器");
    }
}
