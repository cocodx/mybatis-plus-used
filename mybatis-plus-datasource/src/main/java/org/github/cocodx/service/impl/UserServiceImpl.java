package org.github.cocodx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.github.cocodx.entity.User;
import org.github.cocodx.mapper.UserMapper;
import org.github.cocodx.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liugang
 * @since 2022-07-31
 */
@DS("master")//指定所操作的数据源
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
