package com.zwh.store.mapper;

import com.zwh.store.entity.Address;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zwh
 */

@SpringBootTest
public class CartMapperTests {
    @Autowired
    private CartMapper cartMapper;

    @Test
    public void findVOByUid() {
        System.out.println(cartMapper.findVOByUid(1));
    }
}
