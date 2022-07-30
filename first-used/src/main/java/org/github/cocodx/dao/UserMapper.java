package org.github.cocodx.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.github.cocodx.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * BaseMapper的T，表示要操作的实体
 * 在这里设置之后，相当于告诉mybatis-plus，数据库字段跟实体对应的映射建立起来
 * @author amazfit
 * @date 2022-07-30 下午6:50
 **/
//将类或接口，表示成持久层组件
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 根据id，查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String,Object> selectMapById(@Param("id") Long id);
}
