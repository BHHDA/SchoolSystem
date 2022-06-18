package homework.springboothomework.controller;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.Util.SimpleUtil;
import homework.springboothomework.pojo.*;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.*;
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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private NacheckService nacheckService;
    @Autowired
    private TimeerService timeerService;
    @Autowired
    private PlanService planService;
    @Autowired
    private NucleictesterService nucleictesterService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private WaitingService waitingService;
    @GetMapping("/my")
    public String my(HttpSession session,Model model){
        Admin admin=(Admin)session.getAttribute("admin");
        model.addAttribute("admin",admin);
        return "my";
    }
    @GetMapping("/nacheckList")
    public String nacheck(Page page,Model model){
        PageInfo<Nacheck> all = nacheckService.findAll(page);
        model.addAttribute("nacheckpage",all);
        return "nacheck/nacheckList";
    }
    @GetMapping("/timeerList")
    public String timeer(Page page,Model model){
        PageInfo<Timeer> all = timeerService.findAll(page);
        model.addAttribute("timeerpage",all);

        return "timeer/timeerList";
    }
    @PostMapping("/nacheckList")
    public String nacheck3(Page page, Model model, String time){
        PageInfo<Nacheck> all = nacheckService.findListByTime(SimpleUtil.stringToDate(time),page);
        model.addAttribute("nacheckpage",all);
        return "nacheck/nacheckList";
    }
    @PostMapping("/timeerList")
    public String timeer3(Page page,Model model,String time){
        PageInfo<Timeer> all = timeerService.findListByTime(SimpleUtil.stringToDate(time),page);
        model.addAttribute("timeerpage",all);

        return "timeer/timeerList";
    }
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
        System.out.println(nacheck);
        Student student=studentService.findOne(nacheck.getSno());
        Nucleictester nucleictester = nucleictesterService.loginByJno(nacheck.getJobno());
        if(!student.getSname().equals(nacheck.getSname())){
            attributes.addFlashAttribute("message","学号或者姓名输入错误");
            return "redirect:/admin/waitingList";
        }
        else if(!nucleictester.getJname().equals(nacheck.getJname())){
            attributes.addFlashAttribute("message","工号或者核检人员姓名输入错误");
            return "redirect:/admin/waitingList";
        }
        else {

            nacheck.setChangetime(SimpleUtil.dateToString(new Date()));
            System.out.println(nacheck);
            boolean b = nacheckService.addOne(nacheck);
            if(!b){
                attributes.addFlashAttribute("message","添加失败");
                return "redirect:/admin/waitingList";
            }
            attributes.addFlashAttribute("message","添加成功");
            waitingService.deleteOne(nacheck.getSno());
            return "redirect:/admin/waitingList";

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
