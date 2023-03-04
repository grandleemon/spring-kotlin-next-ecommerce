package com.ecommerce.molla.controllers

import com.ecommerce.molla.models.Category
import com.ecommerce.molla.services.CategoryService
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
class CategoryController(private val categoryService: CategoryService) {
    @GetMapping
    fun getAllCategories(): List<Category> = categoryService.getAllCategories()

    @PostMapping
    fun createCategory(@RequestBody category: Category): Category = categoryService.createCategory(category)

    @PutMapping("{id}")
    fun updateCategory(@PathVariable id: Int, category: Category): Category = categoryService.updateCategory(id, category)

    @DeleteMapping("{id}")
    fun deleteCategory(@PathVariable id: Int): Category = categoryService.deleteCategory(id)
}