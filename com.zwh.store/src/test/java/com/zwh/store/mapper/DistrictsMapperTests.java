package com.zwh.store.mapper;

import com.zwh.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zwh
 */

@SpringBootTest
public class DistrictsMapperTests {
    @Autowired
    private DistrictMapper districtMapper;
    @Test
    public void findNameByCode() {

        String name = districtMapper.findNameByCode("610000");
        System.out.println(name);

    }


}
