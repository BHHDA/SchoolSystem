package homework.springboothomework.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//检测更改表
public class Nacheck {
    //员工工号
    private Integer jobno;
    //员工名
    private String jname;
    //学号
    private Integer sno;
    //姓名
    private String sname;
    //更改时间
    private String checktime;
    //检测时间
    private String changetime;
    //检测结果
    private String healthcode;

}
