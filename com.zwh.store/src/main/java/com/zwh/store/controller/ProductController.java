package com.zwh.store.controller;

import com.zwh.store.entity.Product;
import com.zwh.store.service.IProductService;
import com.zwh.store.utils.JsonResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zwh
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController{


    @Autowired
    private IProductService productService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList(){

        List<Product> data = productService.findHotList();
        return new JsonResult<List<Product>>(OK,data);
    }

    @RequestMapping("/{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id){
        Product data = productService.findById(id);
        return new JsonResult<Product>(OK,data);
    }
}
