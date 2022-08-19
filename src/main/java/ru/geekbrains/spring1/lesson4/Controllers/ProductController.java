package ru.geekbrains.spring1.lesson4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.geekbrains.spring1.lesson4.Entities.Product;
import ru.geekbrains.spring1.lesson4.Services.ProductService;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

}
