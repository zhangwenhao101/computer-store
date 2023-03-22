package com.zwh.store.mapper;

import com.zwh.store.entity.Order;
import com.zwh.store.entity.OrderItem;

/**
 * 订单持久层接口
 * @author zwh
 */
public interface OrderMapper {

    /**
     * 插入订单数据
     * @param order 订单数据
     * @return 受影响行数
     */
    Integer insertOrder(Order order);

    /**
     *插入订单项数据
     * @param orderItem 订单项数据
     * @return 受影响行数
     */
    Integer insertOrderItem(OrderItem orderItem);
}
