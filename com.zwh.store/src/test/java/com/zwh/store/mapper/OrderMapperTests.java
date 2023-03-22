package com.zwh.store.mapper;

import com.zwh.store.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zwh
 */

@SpringBootTest
public class OrderMapperTests {
    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void insertOrder() {

        Order order = new Order();
        order.setUid(1);
        order.setRecvName("明明");
        order.setRecvPhone("1234321");
        orderMapper.insertOrder(order);
    }
}
