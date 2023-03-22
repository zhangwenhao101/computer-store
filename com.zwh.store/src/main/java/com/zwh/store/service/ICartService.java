package com.zwh.store.service;

import com.zwh.store.entity.Cart;
import com.zwh.store.vo.CartVO;

import java.util.List;

/**
 * @author zwh
 */
public interface ICartService {

    /**
     * 将商品添加到购物车
     * @param uid 用户id
     * @param pid 商品id
     * @param amount 新增数量
     * @param username 用户名
     * @return
     */
     void addToCart(Integer uid, Integer pid, Integer amount, String username );

     List<CartVO> getVOByUid(Integer uid);


    /**
     * 将购物车中某商品的数量加1
     * @param cid 购物车数量的id
     * @param uid 当前登录的用户的id
     * @param username 当前登录的用户名
     * @return 增加/减少成功后新的数量
     */
    Integer addNum(Integer cid, Integer uid, String username);
    Integer reduceNum(Integer cid, Integer uid, String username);


    /**
     * 根据若干个购物车数据id查询详情的列表
     * @param uid 当前登录的用户的id
     * @param cids 若干个购物车数据id
     * @return 匹配的购物车数据详情的列表
     */
    List<CartVO> getVOByCid(Integer uid, Integer[] cids);
}
