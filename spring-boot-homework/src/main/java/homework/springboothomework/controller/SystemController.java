package homework.springboothomework.controller;

import com.github.pagehelper.PageInfo;

import homework.springboothomework.Util.SimpleUtil;
import homework.springboothomework.pojo.*;
import homework.springboothomework.pojo.query.StudentQuery;
import homework.springboothomework.pojo.query.User;
import homework.springboothomework.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class SystemController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private DoorerService doorerService;
    @Autowired
    private NacheckService nacheckService;
    @Autowired
    private NucleictesterService nucleictesterService;
    @Autowired
    private PlanService planService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TimeerService timeerService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("user",new User());
        return "login";
    }
    @PostMapping("/system")
    public String login(HttpSession session, User user){
        System.out.println(user);
        boolean login;
        if(user.getType()==1){
         login= adminService.login(user.getUsername(), user.getPassword());

        }
        else if(user.getType()==2){
        login= studentService.login(user.getUsername(), user.getPassword());
        }
        else if(user.getType()==3){
            login= doorerService.login(user.getUsername(), user.getPassword());
        }
        else{
            login= nucleictesterService.login(user.getUsername(), user.getPassword());
        }

        if(login){
            if(user.getType()==1){
                Admin admin=adminService.findOneByNo(user.getUsername());

                session.setAttribute("admin",admin);

            }
            else if(user.getType()==2){
                Student student=studentService.loginBySno(user.getUsername());
                session.setAttribute("student",student);
            }
            else if(user.getType()==3){
                Doorer doorer=doorerService.loginByJno(user.getUsername());
                //boolean plan=planService.findOneByJobno(doorer.getJobno(), new Date());
                //if(!plan)return "redirect:/";
                session.setAttribute("doorer",doorer);
            }
            else if(user.getType()==4){
                Nucleictester nucleictester=nucleictesterService.loginByJno(user.getUsername());
                //boolean plan=planService.findOneByJobno(nucleictester.getJobno(),new Date());
                //if(!plan)return "redirect:/";
                session.setAttribute("nucleictester",nucleictester);
            }
            session.setAttribute("loginUser",user);
            System.out.println("登录成功");
            return "system/index";
        }
        else{
            System.out.println("登录失败");
            return "redirect:/";
        }

    }
    @GetMapping("/logout")
    public String logout(HttpSession session,Model model){
        session.invalidate();
        model.addAttribute("user",new User());
        return "login";
    }
    @GetMapping("/system/editpassword")
    public String personalView(Model model){
        model.addAttribute("user",new User());
        return "system/editpassword";
    }

    @PostMapping("/system/editpassword")
    public String edit(HttpSession session, RedirectAttributes attributes,@RequestParam String password, @RequestParam String newpassword, @RequestParam String newpasswordTo){
        System.out.println("password:"+password);
        System.out.println("newpassword:"+newpassword);
        if(!newpassword.equals(newpasswordTo)){
            attributes.addFlashAttribute("message","与输入的新密码不一致");
            return "redirect:/system/editpassword";
        }
        User user=(User)session.getAttribute("loginUser");
        boolean login;
        if(user.getType()==1){
            login= adminService.login(user.getUsername(), password);

        }
        else if(user.getType()==2){
            login= studentService.login(user.getUsername(), password);
        }
        else if(user.getType()==3){
            login= doorerService.login(user.getUsername(), password);
        }
        else{
            login= nucleictesterService.login(user.getUsername(), password);
        }
        if(!login){
            attributes.addFlashAttribute("message","用户输入密码错误");
            return "redirect:/system/editpassword";
        }
        if(user.getType()==1){
            login= adminService.updatePass(user.getUsername(), newpassword);

        }
        else if(user.getType()==2){
            login= studentService.updatePass(user.getUsername(), newpassword);
        }
        else if(user.getType()==3){
            login= doorerService.updatePass(user.getUsername(), newpassword);
        }
        else{
            login= nucleictesterService.updatePass(user.getUsername(), newpassword);
        }
        if(!login){
            attributes.addFlashAttribute("message","用户输入密码错误");
            return "redirect:/system/editpassword";
        }else {
            attributes.addFlashAttribute("message", "修改密码成功，请重新登录");
            return "redirect:/system/editpassword";
        }
    }
}
