package org.github.cocodx;

import org.github.cocodx.dao.UserMapper;
import org.github.cocodx.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author amazfit
 * @date 2022-07-30 下午6:56
 **/
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        //查询一个集和，wrapper条件构造器

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
