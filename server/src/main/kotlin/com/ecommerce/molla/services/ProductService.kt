package com.ecommerce.molla.services

import com.ecommerce.molla.models.Product
import com.ecommerce.molla.repositories.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
    ) {
    fun getAllProducts(): List<Product> = productRepository.findAll();

    fun createProduct(product: Product): Product = productRepository.save(product);
}