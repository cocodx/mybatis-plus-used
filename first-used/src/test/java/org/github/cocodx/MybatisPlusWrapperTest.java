package org.github.cocodx;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.github.cocodx.dao.UserMapper;
import org.github.cocodx.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author amazfit
 * @date 2022-07-31 上午3:54
 **/
@Rollback(value = true)
@Transactional
@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name","a")
                .between("age",20,30)
                .isNotNull("email");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }
}
