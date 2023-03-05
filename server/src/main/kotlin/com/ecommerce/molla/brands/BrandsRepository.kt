package com.ecommerce.molla.brands

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BrandsRepository : JpaRepository<Brand, Int>{
}