package com.zwh.store.controller;

import com.zwh.store.entity.District;
import com.zwh.store.service.IDistrictService;
import com.zwh.store.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zwh
 */
@RestController
@RequestMapping("districts")
public class DistrictController extends BaseController {


    @Autowired
    private IDistrictService districtService;

    @RequestMapping({"/", ""})
    public JsonResult<List<District>> getByParent(String parent) {


        List<District> data = districtService.getByParent(parent);
        return new JsonResult<>(OK, data);
    }
}
