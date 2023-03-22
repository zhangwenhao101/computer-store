package com.zwh.store.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author张文昊
 * @version1.0 Date:2023/3/510:09
 *
 *
 */
@Data
public class User extends BaseEntity implements Serializable {


    private Integer uid;
    private String username;
    private String password;
    private String salt;//盐值
    private String phone;
    private String email ;
    private Integer gender ;//性别：0-女， 1-男
    private String avatar;//头像
    private Integer isDelete;//是否删除：0-未删除，1-已删除'




}
