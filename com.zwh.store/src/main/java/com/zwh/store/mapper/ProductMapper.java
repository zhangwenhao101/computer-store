package com.zwh.store.mapper;

import com.zwh.store.entity.Product;

import java.util.List;

/**
 * @author zwh
 */
public interface ProductMapper {


    List<Product> findHotList();


    Product findById(Integer id);
}
