package com.increff.pos.controller;

import java.util.ArrayList;
import java.util.List;

import com.increff.pos.dto.BrandDto;
import com.increff.pos.model.BrandData;
import com.increff.pos.model.BrandForm;
import com.increff.pos.pojo.BrandPojo;
import com.increff.pos.service.BrandService;
import com.increff.pos.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.increff.pos.service.ApiException;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api
@RestController
public class BrandApiController {
    @Autowired
    private BrandDto dto;


    @ApiOperation(value = "Adds a brand-category combination to database")
    @RequestMapping(path = "/api/admin/brand", method = RequestMethod.POST)
    public void add(@RequestBody BrandForm form) throws ApiException{
        dto.add(form);
    }
    //Using in edit
    @ApiOperation(value = "Gets by ID")
    @RequestMapping(path = "/api/brand/{id}", method = RequestMethod.GET)
    public BrandData get(@PathVariable int id) throws ApiException{
        return dto.get(id);
    }

    @ApiOperation(value = "Gets list of all brand-category combination (Also used for brand report)")
    @RequestMapping(path = "/api/brand", method = RequestMethod.GET)
    public List<BrandData> getAll(){
        return dto.getAll();
    }
    @ApiOperation(value = "Updates a record")
    @RequestMapping(path = "/api/admin/brand/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody BrandForm form) throws ApiException{
        dto.update(id, form);
    }

}
