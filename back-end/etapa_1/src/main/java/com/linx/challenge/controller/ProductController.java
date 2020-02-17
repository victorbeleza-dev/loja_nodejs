package com.linx.challenge.controller;

import com.linx.challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable String id) {
        return ResponseEntity.ok().body(productService.findProductById(id));
    }

    @GetMapping("/{id}/compact")
    public ResponseEntity<Object> getCompactProduct(@PathVariable String id) {
        return ResponseEntity.ok().body(productService.findCompactProductById(id));
    }

}
