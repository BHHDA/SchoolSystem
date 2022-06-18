package homework.springboothomework.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    //学号
    private Integer sno;
    //密码
    private String password;
    //姓名
    private String sname;
    //性别
    private String sex;
    //年龄
    private Integer age;
    //专业
    private String major;
    //个人健康码(Y,N)
    private String healthcode;
    //当前位置
    private  String local;
    //打卡状态（提交,未提交）
    private String clockin;
}
