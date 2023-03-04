package com.ecommerce.molla.repositories

import com.ecommerce.molla.models.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Int> {
}