package com.increff.pos.controller;

import java.util.ArrayList;
import java.util.List;

import com.increff.pos.dto.ProductDto;
import com.increff.pos.model.ProductData;
import com.increff.pos.model.ProductForm;
import com.increff.pos.pojo.ProductPojo;
import com.increff.pos.service.ProductService;
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
public class ProductApiController {
    @Autowired
    private ProductService service;
    @Autowired
    private ProductDto dto;
    @ApiOperation(value = "Adds a brand-category combination to database")
    @RequestMapping(path = "/api/admin/product", method = RequestMethod.POST)
    public void add(@RequestBody ProductForm form) throws ApiException{
        dto.add(form);
    }

    @ApiOperation(value = "Gets by ID")
    @RequestMapping(path = "/api/product/{id}", method = RequestMethod.GET)
    public ProductData get(@PathVariable int id) throws ApiException{
        return dto.get(id);
    }

    @ApiOperation(value = "Gets list of all product data")
    @RequestMapping(path = "/api/product", method = RequestMethod.GET)
    public List<ProductData> getAll() throws ApiException{
        return dto.getAll();
    }

    @ApiOperation(value = "Updates a record")
    @RequestMapping(path = "/api/admin/product/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable int id, @RequestBody ProductForm form) throws ApiException{
        dto.update(id, form);
    }



}
