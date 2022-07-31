package org.github.cocodx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author liugang
 * @since 2022-07-31
 */
@Data
@TableName("t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;

    private String userName;

    private Integer age;

    private String email;

    private Boolean isDeleted;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer version;
}
