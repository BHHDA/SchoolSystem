package homework.springboothomework.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//值班人员表
public class Doorer {
    //工号
    private Integer jobno;
    //密码
    private String password;
    //员工名
    private String jname;
}
