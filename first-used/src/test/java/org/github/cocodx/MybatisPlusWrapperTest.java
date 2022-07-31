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
@Rollback(value = false)
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

    @Test
    public void test02(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 ORDER BY age ASC,uid ASC
        //查询用户信息，按照年龄的降序排序，若年龄相同，则按照id升序排序
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByDesc("age")
                .orderByAsc("uid");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void delete(){
        //删除邮箱地址为9lxzing@gmail.com的用户信息,还有为null的
        //UPDATE t_user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL OR email = ?)
        QueryWrapper<User> objectQueryWrapper = new QueryWrapper<>();
        objectQueryWrapper.isNull("email").or()
                .eq("email","9lxzing@gmail.com");
        int delete = userMapper.delete(objectQueryWrapper);
        System.out.println("result:"+delete);
    }
}
