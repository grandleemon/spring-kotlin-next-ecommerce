package com.ecommerce.molla.repositories

import com.ecommerce.molla.models.Brand
import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository : JpaRepository<Brand, Int>{
}