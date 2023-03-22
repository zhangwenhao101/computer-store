package com.zwh.store.mapper;

import com.zwh.store.entity.District;

import java.util.List;

/**
 * @author zwh
 */
public interface DistrictMapper {

    /**
     * 根据父代号查询区域信息
     * @param parent 父代号
     * @return 某个父区域下的所有区域列表
     */
    List<District> findByParent(String parent);

    /**
     * 根据当前编码查询省市区的名称
     * @param code
     * @return
     */
    String findNameByCode(String code);


}
