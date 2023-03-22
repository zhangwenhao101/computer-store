package com.zwh.store.service;

import com.zwh.store.entity.District;
import com.zwh.store.entity.Order;
import com.zwh.store.mapper.DistrictMapper;
import com.zwh.store.service.impl.DistrictServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author zwh
 */
@SpringBootTest
public class OrderServiceTests {


    @Autowired
    private IOrderService orderService;

    @Test
    public void createOrder() {
        Integer[] a = {2, 3};
        Order o = orderService.create(8,a,1,"红红");
        System.out.println(o);
    }
}