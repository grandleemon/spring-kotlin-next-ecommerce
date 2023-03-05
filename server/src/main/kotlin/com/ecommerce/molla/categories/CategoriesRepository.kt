package com.ecommerce.molla.categories

import org.springframework.data.jpa.repository.JpaRepository

interface CategoriesRepository : JpaRepository<Category, Int> {
}