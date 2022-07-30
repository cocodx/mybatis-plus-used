package org.github.cocodx.mock;

import com.apifan.common.random.source.InternetSource;
import com.apifan.common.random.source.NumberSource;
import com.apifan.common.random.source.PersonInfoSource;
import org.github.cocodx.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author amazfit
 * @date 2022-07-31 上午2:22
 **/
public class UserMock {

    public static User mockEntity(){
        User user = new User();
        user.setName(PersonInfoSource.getInstance().randomChineseName());
        user.setEmail(InternetSource.getInstance().randomEmail(10, "gmail.com"));
        user.setAge(NumberSource.getInstance().randomInt(1, 150));
        return user;
    }

    public static User idMockEntity(){
        User user = mockEntity();
        user.setId(NumberSource.getInstance().randomLong(1, 101));
        return user;
    }

    public static List<User> mockList(int count){
        ArrayList<User> users = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            users.add(mockEntity());
        }
        return users;
    }
}
