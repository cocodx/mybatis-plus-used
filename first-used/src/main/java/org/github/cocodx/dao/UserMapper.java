package org.github.cocodx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.github.cocodx.entity.User;
import org.springframework.stereotype.Repository;

/**
 * BaseMapper的T，表示要操作的实体
 * 在这里设置之后，相当于告诉mybatis-plus，数据库字段跟实体对应的映射建立起来
 * @author amazfit
 * @date 2022-07-30 下午6:50
 **/
//将类或接口，表示成持久层组件
@Repository
public interface UserMapper extends BaseMapper<User> {
}
