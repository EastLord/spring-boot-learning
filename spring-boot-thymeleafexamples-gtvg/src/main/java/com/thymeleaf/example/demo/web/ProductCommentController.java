package com.thymeleaf.example.demo.web;

import com.thymeleaf.example.demo.entity.Product;
import com.thymeleaf.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductCommentController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/comments")
    public String comments(@RequestParam("prodId")Integer prodId,
                           Model model){

        Product product = productService.findById(prodId);

        model.addAttribute("prod",product);
        return "/product/comments";
    }

}
