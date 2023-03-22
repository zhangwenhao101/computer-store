package com.zwh.store.service;

import com.zwh.store.entity.Address;
import com.zwh.store.entity.User;
import com.zwh.store.mapper.UserMapper;
import com.zwh.store.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author zwh
 */
@SpringBootTest
public class AddressServiceTests {
    @Autowired
    private IAddressService addressService;

    @Test
    public void addressService() {

        Address address = new Address();
        address.setPhone("12334");
        address.setName("大唐");
        addressService.addNewAddress(1,"管理员",address);
    }
}