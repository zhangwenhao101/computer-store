package com.zwh.store.mapper;

import com.zwh.store.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author zwh
 * 用户模块的持久层接口
 */
public interface UserMapper {

    /**
     * 插入用户数据
     *
     * @param user 用户数据
     * @return
     */
    Integer insertUser(User user);

    /**
     * 根据用户名查询用户
     *
     * @param Username 用户名
     * @return
     */
    User findByUsername(String Username);

    /**
     * 根据用户uid修改密码
     *
     * @param uid          用户id
     * @param password     用户输入新密码
     * @param modifiedTime 修改时间
     * @param modifiedUser 修改者
     * @return 受影响行数
     */
    Integer updatePasswordByUid(Integer uid,
                                String password,
                                String modifiedUser,
                                Date modifiedTime);

    /**
     * 根据用户id查询用户信息
     *
     * @param uid 用户id
     * @return user对象或者null
     */
    User findByUid(Integer uid);

    /**
     * 更新用户的信息
     * @param user 用户数据
     * @return 受影响行数
     */
    Integer updateInfoByUid(User user);

    Integer updateAvatarByUid(
            @Param("uid") Integer uid,
            @Param("avatar") String avatar,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") Date modifiedTime
    );
}
