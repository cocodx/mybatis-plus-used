package org.github.cocodx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName t_product
 */
@TableName(value ="t_product")
@Data
public class Product implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer price;

    /**
     * 乐观锁版本号
     */
    private Integer version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}