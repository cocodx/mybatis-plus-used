package org.github.cocodx;

import org.github.cocodx.dao.UserMapper;
import org.github.cocodx.entity.User;
import org.github.cocodx.enums.SexEnum;
import org.github.cocodx.mock.UserMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author amazfit
 * @date 2022-07-31 下午5:42
 **/
@SpringBootTest
public class MybatisPlusEnumTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testEnum(){
        User user = UserMock.mockEntity();
        user.setSex(SexEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println("result:"+insert);
    }
}
