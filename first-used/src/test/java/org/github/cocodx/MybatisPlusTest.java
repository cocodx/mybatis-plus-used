package org.github.cocodx;

import org.github.cocodx.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author amazfit
 * @date 2022-07-30 下午6:56
 **/
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    
}
