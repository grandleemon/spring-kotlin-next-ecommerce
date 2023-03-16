package com.ecommerce.molla.categories

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CategoriesService(private val categoriesRepository: CategoriesRepository) {

    fun getAllCategories(): ResponseEntity<List<Category>> {
        val categories = categoriesRepository.findAll();

        if(categories.isEmpty()) return ResponseEntity(HttpStatus.NO_CONTENT)

        return ResponseEntity(categories, HttpStatus.OK)
    }

    fun createCategory(category: Category): ResponseEntity<Category> {
        return ResponseEntity(categoriesRepository.save(category), HttpStatus.OK)
    };

    fun updateCategory(id: Int, category: Category): ResponseEntity<Category> {
        val categoryToUpdate = categoriesRepository.findById(id).orElseThrow{ RuntimeException("Not found Category with id = \"$id\"") };

        categoryToUpdate.name = category.name
        categoryToUpdate.slug = category.slug

        return ResponseEntity(categoriesRepository.save(categoryToUpdate), HttpStatus.OK)
    }

    fun deleteCategory(id: Int): ResponseEntity<HttpStatus> {
        categoriesRepository.deleteById(id);

        return ResponseEntity(HttpStatus.OK);
    }
}