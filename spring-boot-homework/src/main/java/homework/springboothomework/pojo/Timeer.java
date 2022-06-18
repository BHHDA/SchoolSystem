package homework.springboothomework.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//出入时间表
public class Timeer {
    private  Integer no;
    private Integer jobno;
    //员工名
    private String jname;
    //学生学号
    private Integer sno;
    //学生姓名
    private String sname;
    //出校时间
    private String outtime;
    //入校时间
    private String cometime;
    //出校门口
    private String outarea;
    //返校门口
    private String comearea;
    //健康码
    private String heathcode;
}
