package homework.springboothomework.aop;

import homework.springboothomework.pojo.Student;
import homework.springboothomework.service.SignInService;
import homework.springboothomework.service.StudentService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Component
@Aspect
public class WebControllerAop {
 @Autowired
 private SignInService signInService;
 @Autowired
 private StudentService studentService;
 @Pointcut("execution(* homework.springboothomework.controller.StudentController.myAddSignIn*(..))")
 public void execteService(){}
 @Before("execteService()")
  public void domyAddSignInAdvice(JoinPoint joinPoint) throws IOException {
  HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
  HttpSession session = request.getSession();
  HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
  Student student=(Student) session.getAttribute("student");
  System.out.println(student);
  boolean b = signInService.findOneByTimeandSno(student.getSno(), new Date());
  if(!b){
   student.setClockin("未提交");
   studentService.updateOne(student);

  }
  else
  {
   if(!student.getClockin().equals("已提交")){
   student.setClockin("已提交");
   studentService.updateOne(student);
   }
   session.setAttribute("ok","今天已完成健康打卡");
   response.sendRedirect("/student/ok");
  }
  System.out.println(b);

 }
// public void doBeforeAdvice(JoinPoint joinPoint) {
//  HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//  HttpSession session = request.getSession();
//  HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//  char k='\0';
//  System.out.print("健康码-key a y/n: ");
//  Scanner input=new Scanner(System.in);
//  while(k=='\0') {
//   k=input.next().charAt(0);
//  }
//  System.out.println("AOP拦截成功");
//  if(k!='y'){
//   session.setAttribute("key","n");
//   try{
//    response.sendRedirect("/aop/err");
//   }catch (IOException e){
//    e.printStackTrace();
//   }
//  }
//else
//   session.setAttribute("key","y");
// }

}
