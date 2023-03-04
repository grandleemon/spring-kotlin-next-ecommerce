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

    fun updateProduct(id: Int, product: Product): Product {
        val productToUpdate = productRepository.findById(id).orElseThrow()

        productToUpdate.name = product.name
        productToUpdate.new = product.new
        productToUpdate.price = product.price
        productToUpdate.sex = product.sex
        productToUpdate.ratings = product.ratings
        productToUpdate.review = product.review
        productToUpdate.stock = product.stock
        productToUpdate.sold = product.sold
        productToUpdate.slug = product.slug
        productToUpdate.sale_price = product.sale_price

        productRepository.save(productToUpdate)

        return productToUpdate
    }

    fun deleteProduct(id: Int): Product {
        val productToDelete = productRepository.findById(id).orElseThrow()

        productRepository.deleteById(id)

        return productToDelete
    }
}