package com.ecommerce.molla.products

import com.ecommerce.molla.brands.Brand
import com.ecommerce.molla.categories.Category
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
    fun getAllProduct() = productsService.getAllProducts()

    @PostMapping
    fun createProduct(@RequestBody product: Product) = productsService.createProduct(product)

    @PostMapping("{id}/categories")
    fun addCategory(@PathVariable("id") id: Int, @RequestBody category: Category) = productsService.addCategory(id, category)

    @DeleteMapping("{id}/categories")
    fun deleteCategory(@PathVariable("id") id: Int, @RequestBody categories: Category) = productsService.deleteCategory(id, categories)

    @PostMapping("{id}/brands")
    fun addBrand(@PathVariable("id") id: Int, @RequestBody brand: Brand) = productsService.addBrand(id, brand)

    @DeleteMapping("{id}/brands")
    fun deleteBrand(@PathVariable("id") id: Int, @RequestBody brands: Brand) = productsService.deleteBrand(id, brands)


    @PutMapping("/{id}")
    fun updateProduct(@PathVariable("id") id: Int, @RequestBody product: Product) = productsService.updateProduct(id, product)

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable("id") id: Int) = productsService.deleteProduct(id)
}