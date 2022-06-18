package homework.springboothomework.controller;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.Util.SimpleUtil;
import homework.springboothomework.pojo.SignIn;
import homework.springboothomework.pojo.Student;
import homework.springboothomework.pojo.Waiting;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.SignInService;
import homework.springboothomework.service.StudentService;
import homework.springboothomework.service.WaitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private SignInService signInService;
    @Autowired
    private WaitingService waitingService;

    @GetMapping("/student_list")
    public String getStudentList(Model model, Page page){
        PageInfo student=studentService.findAll(page);
        model.addAttribute("studentpage",student);
        return "student/studentList";
    }
    @PostMapping("/student_list")
    public String postStudentList(Model model,String sno,Page page){

        PageInfo student=studentService.findOneBySno(sno,page);
        model.addAttribute("studentpage",student);

        return "student/studentList";
    }
    @GetMapping("/delete/{sno}")
    public String delete(@PathVariable("sno") Integer sno, RedirectAttributes attributes){
        boolean b = studentService.deleteOne(sno);
        if(b){
            attributes.addFlashAttribute("message","删除用户成功");
            return "redirect:/student/student_list";
        }else {
            attributes.addFlashAttribute("message","删除用户失败");
            return "redirect:/student/student_list";
        }
    }
    @GetMapping("/edit/{sno}")
    public String toEdit(@PathVariable String sno,Model model,Page page){
        PageInfo<Student> oneBySno = studentService.findOneBySno(sno,page);
        model.addAttribute("student",oneBySno.getList().get(0));
        return "student/edit";
    }


    @PostMapping("/edit")
    public String edit(Student student, RedirectAttributes attributes,Page page){

        Integer id = student.getSno();
        student.setLocal("在校");
        PageInfo<Student> studentPageInfo = studentService.findOneBySno(id+"",page);
        if(id != null){
                boolean b = studentService.updateOne(student);
                if(b){
                    attributes.addFlashAttribute("message"," 更新用户成功");
                    return "redirect:/student/student_list";
                }else {
                    attributes.addFlashAttribute("message","更新用户失败");
                    return "redirect:/student/student_list";
                }
        }else {
            if(studentPageInfo.getSize() == 0){
                boolean b = studentService.addOne(student);
                if(b){
                    attributes.addFlashAttribute("message"," 新增用户成功");
                    return "redirect:/student/student_list";
                }else {
                    attributes.addFlashAttribute("message","新增用户失败");
                    return "redirect:/student/student_list";
                }
            }else {
                attributes.addFlashAttribute("message","该用户名已存在");
                return "redirect:/student/student_list";
            }
        }
//        return "login";
    }
    @GetMapping("/update")
    public String toUpdate(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "student/edit";
    }
    //
    @GetMapping("/myStudent")
    public String myStudent(Model model, Page page, HttpSession session){
        Student student1 = (Student)session.getAttribute("student");
        PageInfo student=studentService.findOneBySno(student1.getSno()+"",page);
            model.addAttribute("studentpage",student);
        return "student/mystudent";
    }
    @GetMapping("/myAddSignIn")
    public String myAddSignIn(SignIn signIn,Model model,HttpSession session){
        model.addAttribute("signIn",signIn);
        return "student/addSignIn";
    }
    @PostMapping("/myAddSignIn")
    public String postmySignIn(SignIn signIn,HttpSession session){
        if(signIn.getT3()==0)return "redirect:/student/myAddSignIn";
        Student student=(Student)session.getAttribute("student");
        signIn.setSno(student.getSno());
        signIn.setSname(student.getSname());
        signIn.setTime(SimpleUtil.dateToString(new Date()));
        System.out.println(signIn);
        if(signIn.getTemperature()>1 || signIn.getBody()>0 || signIn.getT1()==1 || signIn.getT2()==1){
            waitingService.addOne(new Waiting(signIn.getSno(),signIn.getSname()));
        }
        signInService.addOne(signIn);
        return "redirect:/student/myAddSignIn";
    }
    @RequestMapping("/ok")
    public String ok(RedirectAttributes attributes){
        attributes.addFlashAttribute("message"," 今天已完成健康打卡");
        return "system/message";
    }
}
