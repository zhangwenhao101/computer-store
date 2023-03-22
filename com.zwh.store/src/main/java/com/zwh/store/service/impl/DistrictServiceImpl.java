package com.zwh.store.service.impl;

import com.zwh.store.entity.District;
import com.zwh.store.mapper.DistrictMapper;
import com.zwh.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zwh
 */
@Service
public class DistrictServiceImpl implements IDistrictService {
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {

        List<District> list = districtMapper.findByParent(parent);
        /**
         * 将无效数据设为null，节省流量。
         */
        for (District district : list) {
            district.setId(null);
            district.setParent(null);
        }
        return list;
    }

    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }
}
