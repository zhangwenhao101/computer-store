package com.zwh.store.service;

import com.zwh.store.entity.Product;

import java.util.List;

/**
 * @author zwh
 */
public interface IProductService {


    List<Product> findHotList();

    Product findById(Integer id);
}
