package org.github.cocodx.entity;

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
    private Integer version;
}
