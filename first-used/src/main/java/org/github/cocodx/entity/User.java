package org.github.cocodx.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author amazfit
 * @date 2022-07-30 下午6:48
 **/
@Data
//设置实体类所对应的表名
//@TableName("t_user")
public class User {
    //指定这个属性所对应的字段作为主键
    @TableId(value = "uid")
    private Long id;

    private String name;
    private Integer age;
    private String email;


}
