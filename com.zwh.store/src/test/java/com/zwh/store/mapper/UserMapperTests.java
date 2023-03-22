package com.zwh.store.mapper;

import com.zwh.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zwh
 */

@SpringBootTest
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("tim");
        user.setPassword("1213");
        Integer row = userMapper.insertUser(user);
        System.out.println(row);
    }

    @Test
    public void findByUsername() {

        User user = userMapper.findByUsername("tim");
        System.out.println(user);

    }


}
