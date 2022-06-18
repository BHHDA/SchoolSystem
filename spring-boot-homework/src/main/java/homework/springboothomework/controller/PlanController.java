package homework.springboothomework.controller;

import com.github.pagehelper.PageInfo;

import homework.springboothomework.Util.SimpleUtil;
import homework.springboothomework.pojo.*;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.pojo.query.User;
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
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    private PlanService planService;
    @Autowired
    private DoorerService doorerService;
    @Autowired
    private NucleictesterService nucleictesterService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TimeerService timeerService;
    @Autowired
    private  WaitingService waitingService;
    @GetMapping("/plan_list_Doorer")
    public String getNplanList(Model model, Page page,HttpSession session){
        PageInfo<Plan> planPageInfo=planService.findAllDoorer(page);
        model.addAttribute("planpage",planPageInfo);
        return "plan/planListD";
    }
    @GetMapping("/plan_list_Nucleictester")
    public String plan_list_Nucleictester(Model model, Page page,HttpSession session){

        PageInfo<Plan> planPageInfo=planService.findAllNucleictester(page);

        model.addAttribute("planpage",planPageInfo);
        return "plan/planListN";
    }
    @PostMapping("/plan_list_Doorer")
    public String plan_list_Doorer(Model model, String time, Page page){
        PageInfo<Plan> plan=planService.findListByTimeAndD(SimpleUtil.stringToDate(time),page);
        model.addAttribute("planpage",plan);

        return "plan/planListD";
    }
    @PostMapping("/plan_list_Nucleictester")
    public String postplan_list_Nucleictester(Model model, String time, Page page){
        PageInfo<Plan> plan=planService.findListByTimeAndN(SimpleUtil.stringToDate(time),page);
        model.addAttribute("planpage",plan);

        return "plan/planListN";
    }
    @GetMapping("/deleteD/{no}")
    public String deleteD(@PathVariable("no") Integer no, RedirectAttributes attributes){
        boolean b = planService.deleteOne(no);
        if(b){
            attributes.addFlashAttribute("message","删除用户成功");
            return "redirect:/plan/plan_list_Doorer";
        }else {
            attributes.addFlashAttribute("message","删除用户失败");
            return "redirect:/plan/plan_list_Doorer";
        }
    }
    @GetMapping("/deleteN/{no}")
    public String deleteN(@PathVariable("no") Integer no, RedirectAttributes attributes){
        boolean b = planService.deleteOne(no);
        if(b){
            attributes.addFlashAttribute("message","删除用户成功");
            return "redirect:/plan/plan_list_Nucleictester";
        }else {
            attributes.addFlashAttribute("message","删除用户失败");
            return "redirect:/plan/plan_list_Nucleictester";
        }
    }
    @GetMapping("/editD/{no}")
    public String toEditD(@PathVariable int no,Model model,Page page){
        System.out.println(no);
       Plan plan = planService.findOneByNo(no);

        model.addAttribute("plan",plan);
        return "plan/editD";
    }
    @GetMapping("/editN/{no}")
    public String toEditN(@PathVariable int no,Model model,Page page){
        System.out.println(no);
        Plan plan = planService.findOneByNo(no);

        model.addAttribute("plan",plan);
        return "plan/editN";
    }


    @PostMapping("/editD")
    public String editD(Plan plan, RedirectAttributes attributes,Page page){

        Integer id = plan.getNo();

        Plan plan1 = planService.findOneByNo(id);
        if(id != null){
                boolean b = planService.updateOneByNo(plan);
                if(b){
                    attributes.addFlashAttribute("message"," 更新用户成功");
                    return "redirect:/plan/plan_list_Doorer";
                }else {
                    attributes.addFlashAttribute("message","更新用户失败");
                    return "redirect:/plan/plan_list_Doorer";
                }
        }else {
            if(plan1==null){
                plan.setJname(doorerService.getNameByJno(plan.getJobno()));
                boolean b = planService.addOne(plan);
                if(b){
                    attributes.addFlashAttribute("message"," 新增用户成功");
                    return "redirect:/plan/plan_list_Doorer";
                }else {
                    attributes.addFlashAttribute("message","新增用户失败");
                    return "redirect:/plan/plan_list_Doorer";
                }
            }else {
                attributes.addFlashAttribute("message","该用户名已存在");
                return "redirect:/plan/plan_list_Doorer";
            }
        }

    }
    @PostMapping("/editN")
    public String editN(Plan plan, RedirectAttributes attributes,Page page){

        Integer id = plan.getNo();

        Plan plan1 = planService.findOneByNo(id);
        if(id != null){
            boolean b = planService.updateOneByNo(plan);
            if(b){
                attributes.addFlashAttribute("message"," 更新用户成功");
                return "redirect:/plan/plan_list_Nucleictester";
            }else {
                attributes.addFlashAttribute("message","更新用户失败");
                return "redirect:/plan/plan_list_Nucleictester";
            }
        }else {
            if(plan1==null){
                plan.setJname(nucleictesterService.getNameByJno(plan.getJobno()));
                boolean b = planService.addOne(plan);
                if(b){
                    attributes.addFlashAttribute("message"," 新增用户成功");
                    return "redirect:/plan/plan_list_Nucleictester";
                }else {
                    attributes.addFlashAttribute("message","新增用户失败");
                    return "redirect:/plan/plan_list_Nucleictester";
                }
            }else {
                attributes.addFlashAttribute("message","该用户名已存在");
                return "redirect:/plan/plan_list_Nucleictester";
            }
        }

    }
    @GetMapping("/updateD")
    public String toUpdateD(Model model){
        Plan plan = new Plan();
        model.addAttribute("plan",plan);
        return "plan/editD";
    }
    @GetMapping("/updateN")
    public String toUpdateN(Model model){
        Plan plan = new Plan();
        model.addAttribute("plan",plan);
        return "plan/editN";
    }
    @GetMapping("/myPlan")
    public String myPlan(HttpSession session,Model model, Page page){
        User user=(User)  session.getAttribute("loginUser");
        PageInfo<Plan> planPageInfo;
        if(user.getType()==3){


        Doorer doorer=(Doorer) session.getAttribute("doorer");
         planPageInfo=planService.findListByJno(doorer.getJobno(),page);
        }
        else {
            Nucleictester nucleictester =(Nucleictester) session.getAttribute("nucleictester");
            planPageInfo=planService.findListByJno(nucleictester.getJobno(),page);
        }
        model.addAttribute("planpage",planPageInfo);
        return "plan/myplan";
    }
    @PostMapping( "/myplan_list")
    public String myplan_list(HttpSession session,Model model,String time, Page page){
        User user=(User)  session.getAttribute("loginUser");
        PageInfo<Plan> planPageInfo;
        if(user.getType()==3){
            Doorer doorer=(Doorer) session.getAttribute("doorer");
            Integer jobno = doorer.getJobno();
            planPageInfo=planService.findListByJobnoAndTIme(jobno,SimpleUtil.stringToDate(time),page);
        }else {
            Nucleictester nucleictester =(Nucleictester) session.getAttribute("nucleictester");
            Integer jobno = nucleictester.getJobno();
            planPageInfo=planService.findListByJobnoAndTIme(jobno,SimpleUtil.stringToDate(time),page);
        }
        model.addAttribute("planpage",planPageInfo);
        return "plan/myplan";
    }
    @GetMapping("/addTime")
    public String addTime(Model model){
        Timeer timeer=new Timeer();
        model.addAttribute("timeer",timeer);
        return "plan/addtime";
    }
    @PostMapping("/addTime")
    public String addTime1(Model model, Timeer timeer,HttpSession session,RedirectAttributes attributes){
        Doorer doorer = (Doorer) session.getAttribute("doorer");
        boolean plan=planService.findOneByJobno(doorer.getJobno(), new Date());
        if(!plan){
            attributes.addFlashAttribute("message","不在当班时间内，无权录入数据");
            return "redirect:/plan/addTime";
        }
        Student student=studentService.findOne(timeer.getSno());
        if(!student.getSname().equals(timeer.getSname())){
            attributes.addFlashAttribute("message","学号或者姓名输入错误");
            return "redirect:/plan/addTime";
        }
        else {
            if(timeer.getHeathcode().equals("N")){
                boolean b1 = waitingService.addOne(new Waiting(timeer.getSno(), timeer.getSname()));
                studentService.updateOneByName(timeer.getSno(),timeer.getHeathcode());
                    attributes.addFlashAttribute("message","请该同学尽快进行核算检测");
                    return "redirect:/plan/addTime";
            }
            Plan plan1=planService.findArea(doorer.getJobno(), new Date());
            timeer.setJobno(doorer.getJobno());
            timeer.setJname(doorer.getJname());


            boolean b;
            Timeer local = timeerService.findLocal(timeer.getSno());
            System.out.println("local:"+local);
            Student student1 = new Student();
            student1.setSno(timeer.getSno());
            if(local!=null && local.getComearea()==null) {
                timeer.setCometime(SimpleUtil.dateToString(new Date()));
                timeer.setComearea(plan1.getArea());
                //添加返校记录
                timeer.setNo(local.getNo());
                b=timeerService.updateOne(timeer);
                student1.setLocal("在校");
                studentService.updateOne(student1);
            }
            else {
                timeer.setOuttime(SimpleUtil.dateToString(new Date()));
                timeer.setOutarea(plan1.getArea());
                 b = timeerService.addOne(timeer);
                student1.setLocal("不在校");
                studentService.updateOne(student1);
            }
            if(!b){
                attributes.addFlashAttribute("message","添加失败");
                return "redirect:/plan/addTime";
            }


            System.out.println(timeer);

            attributes.addFlashAttribute("message","添加成功");
            return "redirect:/plan/addTime";

        }
    }
}
