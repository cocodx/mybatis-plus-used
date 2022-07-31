package org.github.cocodx;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.apache.commons.lang3.StringUtils;
import org.github.cocodx.dao.UserMapper;
import org.github.cocodx.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

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

    @Test
    public void test03Update(){
        //UPDATE t_user SET user_name=?, email=? WHERE is_deleted=0 AND (age > ? AND user_name LIKE ? OR email IS NULL)
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20)
                .like("user_name", "a")
                .or()
                .isNull("email");
        User user = new User();
        user.setName("xiaoming");
        user.setEmail("ming@gmail.com");
        userMapper.update(user,wrapper);
    }

    @Test
    public void test05(){
        //将用户中包含有a，并且（年龄大于20或者email为null）的用户信息修改
        //lambda 中的条件优先执行
        //UPDATE t_user SET user_name=?, age=?, email=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.like("user_name","x")
                .and(item->{
                    item.gt("age",20)
                            .or()
                            .isNull("email");
                });
        User user = new User();
        user.setName("小红");
        user.setAge(25);
        user.setEmail("test@gmail.com");
        userMapper.update(user,userQueryWrapper);
    }

    @Test
    public void test06(){
        //SELECT user_name,age,email FROM t_user WHERE is_deleted=0
        //查询用户的用户名，年龄，邮箱
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("user_name","age","email");
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test07(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (uid IN (select uid from t_user where uid<=100))
        //查询id小于等于100的用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("uid","select uid from t_user where uid<=100");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test08(){
        //UPDATE t_user SET user_name=?,email=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        //将用户中包含有a，并且（年龄大于20或者email为null）的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("user_name", "红").and(item -> {
            item.gt("age", 20).or().isNull("email");
        });
        //set设置要修改的字段
        updateWrapper.set("user_name", "xiaohei").set("email", "hei@gmail.com");
        int update = userMapper.update(null, updateWrapper);
        System.out.println("result:"+update);
    }

    @Test
    public void test09(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (age >= ? AND age <= ?)
        String userName="h";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (!StringUtils.isBlank(userName)){
            wrapper.like("user_name",userName);
        }
        if (ageBegin!=null){
            //大于等于 >=
            wrapper.ge("age",ageBegin);
        }
        if (ageEnd!=null){
            wrapper.le("age",ageEnd);
        }
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test10(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
        String userName="h";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(userName),"user_name",userName)
                .ge(ageBegin!=null,"age",ageBegin)
                .le(ageEnd!=null,"age",ageEnd);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test11(){
        //SELECT uid AS id,user_name AS name,age,email,is_deleted FROM t_user WHERE is_deleted=0 AND (user_name LIKE ? AND age <= ?)
        String userName="h";
        Integer ageBegin = null;
        Integer ageEnd = 30;

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(userName), User::getName,userName)
                .ge(ageBegin!=null,User::getAge,ageBegin)
                .le(ageEnd!=null,User::getAge,ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test12(){
        //UPDATE t_user SET user_name=?,email=? WHERE is_deleted=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.like(User::getName,"h")
                .and(i->{
                    i.gt(User::getAge,20).or().isNull(User::getEmail);
                });
        updateWrapper.set(User::getName,"小黑").set(User::getEmail,"860721890@qq.com");
        int update = userMapper.update(null,updateWrapper);
        System.out.println("result:"+update);
    }
}
