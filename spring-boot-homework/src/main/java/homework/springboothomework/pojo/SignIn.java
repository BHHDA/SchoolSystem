package homework.springboothomework.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//每日打卡表
public class SignIn {
    private Integer sno;
    private String sname;
    private Integer temperature;
    private Integer body;
    private Integer t1;
    private Integer t2;
    private Integer t3;
    private  String time;
}
