package me.sungJ.productManager.Presentation;

import me.sungJ.productManager.Application.SimpleProductService;
import me.sungJ.productManager.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    private SimpleProductService simpleProductService;

    @Autowired
    ProductController(SimpleProductService simpleProductService) {
        this.simpleProductService = simpleProductService;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return simpleProductService.add(product);
    }
}
