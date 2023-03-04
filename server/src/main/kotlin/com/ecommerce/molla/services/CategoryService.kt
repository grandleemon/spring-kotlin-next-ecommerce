package com.ecommerce.molla.services

import com.ecommerce.molla.models.Category
import com.ecommerce.molla.repositories.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {

    fun getAllCategories(): List<Category> = categoryRepository.findAll()

    fun createCategory(category: Category): Category = categoryRepository.save(category);

    fun updateCategory(id: Int, category: Category): Category {
        val categoryToUpdate = categoryRepository.findById(id).orElseThrow();

        categoryToUpdate.name = category.name
        categoryToUpdate.slug = category.slug

        categoryRepository.save(categoryToUpdate)

        return categoryToUpdate
    }

    fun deleteCategory(id: Int): Category {
        val categoryToDelete = categoryRepository.findById(id).orElseThrow();

        categoryRepository.deleteById(id);

        return categoryToDelete;
    }
}