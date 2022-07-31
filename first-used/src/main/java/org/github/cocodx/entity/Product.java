package org.github.cocodx.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author amazfit
 * @date 2022-07-31 下午5:14
 **/
@Data
public class Product {

    private Long id;
    private String name;
    private Integer price;

    @Version //表示乐观锁版本号字段
    private Integer version;
}
