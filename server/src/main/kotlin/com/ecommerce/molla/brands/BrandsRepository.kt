package com.ecommerce.molla.brands

import org.springframework.data.jpa.repository.JpaRepository

interface BrandsRepository : JpaRepository<Brand, Int>{
}