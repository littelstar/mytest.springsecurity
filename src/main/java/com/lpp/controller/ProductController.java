package com.lpp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/product")
public class ProductController {
    @RequestMapping("/save")
    public String  save(){
        return "product/productSave";
    }
    @RequestMapping("/list")
    public String list(){
        return "product/productList";
    }
    @RequestMapping("/del")
    public String del(){
        return "product/productDel";
    }
    @RequestMapping("/update")
    public String update(){
        return "product/productUpdate";
    }

}
