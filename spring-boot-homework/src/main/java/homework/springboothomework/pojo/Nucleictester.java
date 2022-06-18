package homework.springboothomework.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
//核酸区域检测人员表
public class Nucleictester {
    //工号
    private Integer jobno;
    //密码
    private String password;
    //员工名
    private String jname;

}
