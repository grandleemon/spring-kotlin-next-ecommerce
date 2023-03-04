package com.ecommerce.molla.controllers

import com.ecommerce.molla.models.Product
import com.ecommerce.molla.services.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class ProductController(private val productService: ProductService) {
    @GetMapping("/products")
    fun getAllProduct(): List<Product> = productService.getAllProducts()

    @PostMapping("/products")
    fun createProduct(@RequestBody product: Product): Product = productService.createProduct(product)
}