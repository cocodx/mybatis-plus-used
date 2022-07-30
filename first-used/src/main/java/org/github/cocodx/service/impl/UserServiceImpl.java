package org.github.cocodx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.github.cocodx.dao.UserMapper;
import org.github.cocodx.entity.User;
import org.github.cocodx.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author amazfit
 * @date 2022-07-31 上午2:15
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
