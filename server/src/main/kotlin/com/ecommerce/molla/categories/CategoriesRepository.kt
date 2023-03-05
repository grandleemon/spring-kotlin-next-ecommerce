package com.ecommerce.molla.categories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoriesRepository : JpaRepository<Category, Int> {
}