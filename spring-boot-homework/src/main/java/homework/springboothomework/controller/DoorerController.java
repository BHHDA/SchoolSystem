package homework.springboothomework.controller;

import com.github.pagehelper.PageInfo;
import homework.springboothomework.pojo.Doorer;
import homework.springboothomework.pojo.Student;
import homework.springboothomework.pojo.query.Page;
import homework.springboothomework.service.DoorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/doorer")
public class DoorerController {
@Autowired
private DoorerService doorerService;
    @GetMapping("/doorer_list")
    public String getDoorerList(Model model, Page page){
        PageInfo<Doorer> doorerPageInfo=doorerService.findAll(page);
        model.addAttribute("doorerpage",doorerPageInfo);
        return "doorer/doorerList";
    }
    @PostMapping("/doorer_list")
    public String postDoorerList(Model model,String jobno,Page page){

        PageInfo<Doorer> doorer=doorerService.findOneByJno(jobno,page);
        model.addAttribute("doorerpage",doorer);

        return "doorer/doorerList";
    }
    @GetMapping("/delete/{jobno}")
    public String delete(@PathVariable("jobno") Integer jobno, RedirectAttributes attributes){
        boolean b = doorerService.deleteOne(jobno);
        if(b){
            attributes.addFlashAttribute("message","删除用户成功");
            return "redirect:/doorer/doorer_list";
        }else {
            attributes.addFlashAttribute("message","删除用户失败");
            return "redirect:/doorer/doorer_list";
        }
    }
    @GetMapping("/edit/{jobno}")
    public String toEdit(@PathVariable String jobno,Model model,Page page){
        System.out.println(jobno);
        PageInfo<Doorer> oneBySno = doorerService.findOneByJno(jobno,page);

        model.addAttribute("doorer",oneBySno.getList().get(0));
        return "doorer/edit";
    }


    @PostMapping("/edit")
    public String edit(Doorer doorer, RedirectAttributes attributes,Page page){

        Integer id = doorer.getJobno();

        PageInfo<Doorer> doorerPageInfo = doorerService.findOneByJno(id+"",page);
        if(id != null){
                boolean b = doorerService.updateOne(doorer);
                if(b){
                    attributes.addFlashAttribute("message"," 更新用户成功");
                    return "redirect:/doorer/doorer_list";
                }else {
                    attributes.addFlashAttribute("message","更新用户失败");
                    return "redirect:/doorer/doorer_list";
                }
        }else {
            if(doorerPageInfo.getSize() == 0){
                boolean b = doorerService.addOne(doorer);
                if(b){
                    attributes.addFlashAttribute("message"," 新增用户成功");
                    return "redirect:/doorer/doorer_list";
                }else {
                    attributes.addFlashAttribute("message","新增用户失败");
                    return "redirect:/doorer/doorer_list";
                }
            }else {
                attributes.addFlashAttribute("message","该用户名已存在");
                return "redirect:/doorer/doorer_list";
            }
        }
//        return "login";
    }
    @GetMapping("/update")
    public String toUpdate(Model model){
        Doorer doorer = new Doorer();
        model.addAttribute("doorer",doorer);
        return "doorer/edit";
    }
}
