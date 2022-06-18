package homework.springboothomework.controller;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.Util.SimpleUtil;
import homework.springboothomework.pojo.*;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.NacheckService;
import homework.springboothomework.service.PlanService;
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
@RequestMapping("/nacheck")
public class NacheckController {
    @Autowired
    private PlanService planService;
    @Autowired
    private NacheckService nacheckService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private WaitingService waitingService;
    @GetMapping("/addTime/{sno}")
    public String addTime(@PathVariable("sno") Integer sno,Model model){
        Nacheck nacheck=new Nacheck();
        nacheck.setSno(sno);
        nacheck.setSname(studentService.findOne(sno).getSname());
        model.addAttribute("nacheck",nacheck);
        return "nacheck/addtime";
    }
    @PostMapping("/addTime")
    public String addTime1(Model model, Nacheck nacheck, HttpSession session, RedirectAttributes attributes){
        Nucleictester nucleictester = (Nucleictester) session.getAttribute("nucleictester");
        boolean plan=planService.findOneByJobno(nucleictester.getJobno(),new Date());
        if(!plan){
            attributes.addFlashAttribute("message","不在当班时间内，无权录入数据");
            return "redirect:/nacheck/waitingList";
        }
        Student student=studentService.findOne(nacheck.getSno());
        if(!student.getSname().equals(nacheck.getSname())){
            attributes.addFlashAttribute("message","学号或者姓名输入错误");
            return "redirect:/nacheck/waitingList";
        }
        else {

            nacheck.setJobno(nucleictester.getJobno());
            nacheck.setJname(nucleictester.getJname());
            nacheck.setChangetime(SimpleUtil.dateToString(new Date()));
            System.out.println(nacheck);
            boolean b = nacheckService.addOne(nacheck);
            if(!b){
                attributes.addFlashAttribute("message","添加失败");
                return "redirect:/nacheck/waitingList";
            }
            boolean b1 = studentService.updateOneByName(nacheck.getSno(), nacheck.getHealthcode());
            if(!b1){
                attributes.addFlashAttribute("message","信息无误，但同步失败，请重新提交");
                return "redirect:/nacheck/waitingList";
            }

            attributes.addFlashAttribute("message","添加成功");
            waitingService.deleteOne(nacheck.getSno());
            return "redirect:/nacheck/waitingList";

        }
    }
    @GetMapping("/waitingList")
    public String waitingList(Model model, Page page){
        PageInfo waitingPageInfo=waitingService.findAll(page);
        model.addAttribute("waitingPageInfo",waitingPageInfo);
        return "waiting/waitingList";
    }
    @PostMapping("/waitingList")
    public String waitingList2(Model model, Page page, String sno){
        PageInfo waitingPageInfo=waitingService.findListBySno(sno,page);
        model.addAttribute("waitingPageInfo",waitingPageInfo);
        return "waiting/waitingList";
    }
}
