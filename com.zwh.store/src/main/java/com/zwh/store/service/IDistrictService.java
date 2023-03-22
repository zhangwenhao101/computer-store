package com.zwh.store.service;

import com.zwh.store.entity.District;

import java.util.List;

/**
 * @author zwh
 */
public interface IDistrictService {

    /**
     * 根据父代号查询区域信息
     *
     * @param parent 父代号
     * @return 区域信息
     */
    List<District> getByParent(String parent);

    String getNameByCode(String code);
}
