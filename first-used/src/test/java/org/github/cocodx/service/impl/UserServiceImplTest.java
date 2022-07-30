package org.github.cocodx.service.impl;

import org.github.cocodx.entity.User;
import org.github.cocodx.mock.UserMock;
import org.github.cocodx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@Rollback(value = true)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println(count);
    }

    @Test
    public void testBatchInsert(){
        List<User> users = UserMock.mockList(100);
        boolean b = userService.saveBatch(users);
        System.out.println("result:"+b);
    }

}