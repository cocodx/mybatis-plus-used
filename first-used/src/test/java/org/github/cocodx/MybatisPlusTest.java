package org.github.cocodx;

import org.github.cocodx.dao.UserMapper;
import org.github.cocodx.entity.User;
import org.github.cocodx.mock.UserMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

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

    @Test
    public void testInsert(){
        User user = UserMock.mockEntity();
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println("id:"+user.getId());
    }

    @Test
    public void testDelete(){
        //通过id删除用户信息
        /*int i = userMapper.deleteById(1553349533335830529L);
        System.out.println("result:"+i);*/

        //根据map集和中，设置的条件删除用户信息
       /* HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("name","雪峰");
        hashMap.put("age",25);
        int i = userMapper.deleteByMap(hashMap);
        System.out.println("result:"+i);*/

        //通过多个id实现批量删除
        /*List<Long> longs = Arrays.asList(1496533042804662273L, 1496533042804662274L, 3L);
        int i = userMapper.deleteBatchIds(longs);
        System.out.println("result:"+i);*/
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(1553349349637918721L);
        user.setName("大军儿");
        user.setAge(24);
        user.setEmail("dajuner@gmail.com");
        int i = userMapper.updateById(user);
        System.out.println("result:"+i);
    }

    @Test
    public void testSelect(){
        //通过id查询用户信息
/*        User user = userMapper.selectById(1L);
        System.out.println(user);*/

        //根据多个id实现批量查询
        /*List<Long> longs = Arrays.asList(1496533042804662275L, 1553349349637918721L);
        List<User> users = userMapper.selectBatchIds(longs);
        users.forEach(System.out::println);*/

/*        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("name","jack");
        hashMap.put("age",20);
        List<User> users = userMapper.selectByMap(hashMap);
        users.forEach(System.out::println);*/

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelect1(){
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }
}
