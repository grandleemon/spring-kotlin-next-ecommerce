package com.ecommerce.molla.services

import com.ecommerce.molla.models.Category
import com.ecommerce.molla.models.Product
import com.ecommerce.molla.repositories.CategoryRepository
import com.ecommerce.molla.repositories.ProductRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val categoryRepository: CategoryRepository
    ) {
    fun getAllProducts(): List<Product> = productRepository.findAll();

    fun createProduct(product: Product): Product = productRepository.save(product);

    fun addCategory(id: Int, category: Category): ResponseEntity<Product> {
        val product: Product = productRepository.findById(id).orElseThrow()
        val categoryToFind: Optional<Category> = categoryRepository.findById(category.id)
        return if(categoryToFind.isPresent) {
            product.categories.add(categoryToFind.get())
            productRepository.save(product)
            ResponseEntity<Product>(product, HttpStatus.CREATED)
        } else {
            categoryRepository.save(category)
            product.categories.add(category)
            productRepository.save(product)
            ResponseEntity<Product>(product, HttpStatus.CREATED)
        }
    }

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

    fun deleteCategory(id: Int, categories: Category): ResponseEntity<Product> {
        val product = productRepository.findById(id).orElseThrow()

        product.categories.remove(categories)
        productRepository.save(product)

        return ResponseEntity(product, HttpStatus.OK)
    }
}