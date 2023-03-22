package com.zwh.store.service;

import com.zwh.store.entity.User;
import com.zwh.store.mapper.UserMapper;
import com.zwh.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author zwh
 */
@SpringBootTest
public class UserServiceTests {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void reg() {

        try {
            User user = new User();
            user.setUsername("test01");
            user.setPassword("123");
            iUserService.reg(user);
            System.out.println("OK");
        } catch (ServiceException e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login() {
        User user = iUserService.login("jack05", "123");
        System.out.println(user);
    }

    @Test
    public void updatePassword() {
        Integer rows = userMapper.updatePasswordByUid(06, "123", "管理员", new Date());
        System.out.println(rows);
    }

    @Test
    public void findByUid() {
        User user = userMapper.findByUid(06);
        System.out.println(user);
    }

    @Test
    public void changePassword() {
        iUserService.changePassword(8, "test01", "123", "456");
    }

    @Test
    public void updateInfoByUid() {
        User user = new User();
        user.setUid(1);
        user.setPhone("123321");
        user.setEmail("test01@qq.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }

    @Test
    public void getByUid() {
        System.out.println(iUserService.getByUid(1));
    }

    @Test
    public void changeInfo() {
        User user = new User();
        user.setPhone("123456");
        user.setEmail("124@wx.com");
        user.setGender(0);
        iUserService.changeInfo(01, "test01", user);
    }
    @Test
    public void updateAvatarByUid() {
        User user = new User();
        userMapper.updateAvatarByUid(01,"/upload/avatar.png","管理员",new Date());
    }
    @Test
    public void changeAvatar() {

        iUserService.changeAvatar(1,"/upload/test.png","小明");
    }


    @Test
    public void da(){
        Integer a1 = 1;
        Integer a2 = 1;
        System.out.println(a1==a2);
    }
}