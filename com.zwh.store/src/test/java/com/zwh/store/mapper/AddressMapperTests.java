package com.zwh.store.mapper;

import com.zwh.store.entity.Address;
import com.zwh.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zwh
 */

@SpringBootTest
public class AddressMapperTests {
    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(1);
        address.setPhone("123456");
        address.setName("女朋友");
        Integer rows = addressMapper.insert(address);
        System.out.println(rows);
    }
    @Test
    public void countByUid() {
        Integer rows = addressMapper.countByUid(1);
        System.out.println(rows);
    }

}
