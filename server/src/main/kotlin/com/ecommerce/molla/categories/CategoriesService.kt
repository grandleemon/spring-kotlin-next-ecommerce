package com.ecommerce.molla.categories

import org.springframework.stereotype.Service

@Service
class CategoriesService(private val categoriesRepository: CategoriesRepository) {

    fun getAllCategories(): List<Category> = categoriesRepository.findAll()

    fun createCategory(category: Category): Category = categoriesRepository.save(category);

    fun updateCategory(id: Int, category: Category): Category {
        val categoryToUpdate = categoriesRepository.findById(id).orElseThrow();

        categoryToUpdate.name = category.name
        categoryToUpdate.slug = category.slug

        categoriesRepository.save(categoryToUpdate)

        return categoryToUpdate
    }

    fun deleteCategory(id: Int): Category {
        val categoryToDelete = categoriesRepository.findById(id).orElseThrow();

        categoriesRepository.deleteById(id);

        return categoryToDelete;
    }
}