package homework.springboothomework.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentQuery {
    private Integer from=1;
    private Integer pageSize=5;
    private String name;

}
