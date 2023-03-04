package com.ecommerce.molla.controllers

import com.ecommerce.molla.models.Product
import com.ecommerce.molla.services.ProductService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/products")
class ProductController(private val productService: ProductService) {
    @GetMapping
    fun getAllProduct(): List<Product> = productService.getAllProducts()

    @PostMapping
    fun createProduct(@RequestBody product: Product): Product = productService.createProduct(product)

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable("id") id: Int, @RequestBody product: Product): Product = productService.updateProduct(id, product)

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable("id") id: Int): Product = productService.deleteProduct(id)
}