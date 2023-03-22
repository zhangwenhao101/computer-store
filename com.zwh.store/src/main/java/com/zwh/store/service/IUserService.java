package com.zwh.store.service;

import com.zwh.store.entity.User;

/**
 * @author zwh
 * 用户模块业务层接口
 */
public interface IUserService {

    /**
     * 用户注册
     *
     * @param user 用户的数据对象
     */
    void reg(User user);

    User login(String username, String password);

    void changePassword(Integer uid,
                        String username,
                        String oldPassword,
                        String newPassword);

    /**
     * 根据id查询用户数据
     *
     * @param uid 用户id
     * @return 用户数据
     */
    User getByUid(Integer uid);

    /**
     * 更新用户数据
     *
     * @param uid      用户id
     * @param username 用户名
     * @param user     用户数据
     */
    void changeInfo(Integer uid, String username, User user);

    /**
     * 修改用户头像
     * @param uid 用户id
     * @param avatar 用户头像的路径
     * @param username 用户名
     */
    void changeAvatar(
            Integer uid,
            String avatar,
            String username);
}

