package com.ecommerce.molla.products

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductsRepository : JpaRepository<Product, Int> {
}