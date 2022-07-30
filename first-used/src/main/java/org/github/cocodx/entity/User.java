package org.github.cocodx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
//    AUTO是自增，数据库主键也要设置自增
//    ASSIGN_ID是雪花数，默认就是雪花数
    //指定这个属性所对应的字段作为主键
    @TableId(value = "uid",type = IdType.AUTO)//要使AUTO生效，数据库也要主键自增设置
    private Long id;

    @TableField(value = "user_name")
    private String name;
    private Integer age;
    private String email;


}
