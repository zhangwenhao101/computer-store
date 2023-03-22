package com.zwh.store.service;

import com.zwh.store.entity.District;
import com.zwh.store.entity.User;
import com.zwh.store.mapper.DistrictMapper;
import com.zwh.store.mapper.UserMapper;
import com.zwh.store.service.ex.ServiceException;
import com.zwh.store.service.impl.DistrictServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

/**
 * @author zwh
 */
@SpringBootTest
public class DistrictTests {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private DistrictServiceImpl districtService;

    @Test
    public void changeAvatar() {

        List<District> list = districtMapper.findByParent("210100");
        for (District district : list) {
            System.out.println(district);
        }
    }


    @Test
    public void getByParent() {
        List<District> list = districtService.getByParent("86");
        for (District district : list) {
            System.out.println(district);
        }
    }
}