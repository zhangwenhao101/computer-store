package com.zwh.store.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zwh
 */
@SpringBootTest
public class CartServiceTests {

    @Autowired
    private ICartService cartService;
    @Test
    public void addToCart(){
        cartService.addToCart(1,10000003,2,"test01");
    }
}
