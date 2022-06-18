package homework.springboothomework.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//人员安排表
public class Plan {
    private Integer no;
    //工号
    private Integer jobno;
    //员工名
    private String jname;
    //区域
    private String area;
    //值班时间段
    private String starttime;
    private String endtime;
}
