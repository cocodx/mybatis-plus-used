package org.github.cocodx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author amazfit
 * @date 2022-07-30 下午6:48
 **/
@Data
public class User {

    private Long id;
    private String name;
    private Integer age;
    private String email;


}
