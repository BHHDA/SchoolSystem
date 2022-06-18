package homework.springboothomework.controller;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.Util.SimpleUtil;
import homework.springboothomework.pojo.Nacheck;
import homework.springboothomework.pojo.Nucleictester;
import homework.springboothomework.pojo.Student;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.NucleictesterService;
import homework.springboothomework.service.PlanService;
import homework.springboothomework.service.StudentService;
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
@RequestMapping("/nucleictester")
public class NucleictesterController {
    @Autowired
    private PlanService planService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private NucleictesterService nucleictesterService;
    @GetMapping("/nucleictester_list")
    public String getNucleictesterList(Model model, Page page){
        PageInfo<Nucleictester> nucleictesterPageInfo=nucleictesterService.findAll(page);
        model.addAttribute("nucleictesterpage",nucleictesterPageInfo);
        return "nucleictester/nucleictesterList";
    }
    @PostMapping("/nucleictester_list")
    public String postNucleictesterList(Model model,String jobno,Page page){

        PageInfo<Nucleictester> nucleictester=nucleictesterService.findOneByJno(jobno,page);
        model.addAttribute("nucleictesterpage",nucleictester);

        return "nucleictester/nucleictesterList";
    }
    @GetMapping("/delete/{jobno}")
    public String delete(@PathVariable("jobno") Integer jobno, RedirectAttributes attributes){
        boolean b = nucleictesterService.deleteOne(jobno);
        if(b){
            attributes.addFlashAttribute("message","删除用户成功");
            return "redirect:/nucleictester/nucleictester_list";
        }else {
            attributes.addFlashAttribute("message","删除用户失败");
            return "redirect:/nucleictester/nucleictester_list";
        }
    }
    @GetMapping("/edit/{jobno}")
    public String toEdit(@PathVariable String jobno,Model model,Page page){
        System.out.println(jobno);
        PageInfo<Nucleictester> oneBySno = nucleictesterService.findOneByJno(jobno,page);

        model.addAttribute("nucleictester",oneBySno.getList().get(0));
        return "nucleictester/edit";
    }


    @PostMapping("/edit")
    public String edit(Nucleictester nucleictester, RedirectAttributes attributes,Page page){

        Integer id = nucleictester.getJobno();

        PageInfo<Nucleictester> nucleictesterPageInfo = nucleictesterService.findOneByJno(id+"",page);
        if(id != null){
            System.out.println(nucleictester);
                boolean b = nucleictesterService.updateOne(nucleictester);
                if(b){
                    attributes.addFlashAttribute("message"," 更新用户成功");
                    return "redirect:/nucleictester/nucleictester_list";
                }else {
                    attributes.addFlashAttribute("message","更新用户失败");
                    return "redirect:/nucleictester/nucleictester_list";
                }
        }else {
            if(nucleictesterPageInfo.getSize() == 0){
                boolean b = nucleictesterService.addOne(nucleictester);
                if(b){
                    attributes.addFlashAttribute("message"," 新增用户成功");
                    return "redirect:/nucleictester/nucleictester_list";
                }else {
                    attributes.addFlashAttribute("message","新增用户失败");
                    return "redirect:/nucleictester/nucleictester_list";
                }
            }else {
                attributes.addFlashAttribute("message","该用户名已存在");
                return "redirect:/nucleictester/nucleictester_list";
            }
        }
//        return "login";
    }
    @GetMapping("/update")
    public String toUpdate(Model model){
        Nucleictester nucleictester = new Nucleictester();
        model.addAttribute("nucleictester",nucleictester);
        return "nucleictester/edit";
    }

    @GetMapping("/sethealthcode")
    public String addTime(Model model){
        Student student=new Student();

        model.addAttribute("student",student);
        return "student/sethealthcode";
    }
    @PostMapping("/sethealthcode")
    public String addTime1(Model model,Student student, HttpSession session, RedirectAttributes attributes){
        Nucleictester nucleictester = (Nucleictester) session.getAttribute("nucleictester");
        boolean plan=planService.findOneByJobno(nucleictester.getJobno(),new Date());
        if(!plan){
            attributes.addFlashAttribute("message","不在当班时间内，无权录入数据");
            return "redirect:/nucleictester/sethealthcode";
        }
        Student student1=studentService.findOne(student.getSno());
        if(!student.getSname().equals(student1.getSname())){
            attributes.addFlashAttribute("message","学号或者姓名输入错误");
            return "redirect:/nucleictester/sethealthcode";
        }
        else {
            boolean b1 = studentService.updateOneByName(student.getSno(), student.getHealthcode());
            if(!b1){
                attributes.addFlashAttribute("message","信息无误，但同步失败，请重新提交");
                return "redirect:/nucleictester/sethealthcode";
            }
            attributes.addFlashAttribute("message","更改成功");
            return "redirect:/nucleictester/sethealthcode";

        }
    }
}
