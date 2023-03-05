package com.ecommerce.molla.products

import com.ecommerce.molla.brands.Brand
import com.ecommerce.molla.categories.Category
import org.springframework.http.ResponseEntity
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
class ProductsController(private val productsService: ProductsService) {
    @GetMapping
    fun getAllProduct(): List<Product> = productsService.getAllProducts()

    @PostMapping
    fun createProduct(@RequestBody product: Product): Product = productsService.createProduct(product)

    @PostMapping("{id}/categories")
    fun addCategory(@PathVariable("id") id: Int, @RequestBody category: Category): ResponseEntity<Product> {
        return productsService.addCategory(id, category)
    }

    @DeleteMapping("{id}/categories")
    fun deleteCategory(@PathVariable("id") id: Int, @RequestBody categories: Category): ResponseEntity<Product> {
        return productsService.deleteCategory(id, categories)
    }

    @PostMapping("{id}/brands")
    fun addBrand(@PathVariable("id") id: Int, @RequestBody brand: Brand): ResponseEntity<Product> {
        return productsService.addBrand(id, brand)
    }

    @DeleteMapping("{id}/brands")
    fun deleteBrand(@PathVariable("id") id: Int, @RequestBody brands: Brand): ResponseEntity<Product> {
        return productsService.deleteBrand(id, brands)
    }

    @PutMapping("/{id}")
    fun updateProduct(@PathVariable("id") id: Int, @RequestBody product: Product): Product = productsService.updateProduct(id, product)

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable("id") id: Int): Product = productsService.deleteProduct(id)
}