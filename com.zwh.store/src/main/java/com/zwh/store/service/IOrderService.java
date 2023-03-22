package com.zwh.store.service;

import com.zwh.store.entity.Order;

/**
 * @author zwh
 */
public interface IOrderService {

    Order create(Integer aid, Integer[] cids, Integer uid, String username);
}
