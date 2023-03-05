package com.ecommerce.molla.categories

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1/categories")
class CategoriesController(private val categoriesService: CategoriesService) {
    @GetMapping
    fun getAllCategories(): List<Category> = categoriesService.getAllCategories()

    @PostMapping
    fun createCategory(@RequestBody category: Category): Category = categoriesService.createCategory(category)

    @PutMapping("{id}")
    fun updateCategory(@PathVariable id: Int, @RequestBody category: Category): Category = categoriesService.updateCategory(id, category)

    @DeleteMapping("{id}")
    fun deleteCategory(@PathVariable id: Int): Category = categoriesService.deleteCategory(id)
}