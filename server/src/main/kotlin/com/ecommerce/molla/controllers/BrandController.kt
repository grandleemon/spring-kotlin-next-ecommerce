package com.ecommerce.molla.controllers

import com.ecommerce.molla.models.Brand
import com.ecommerce.molla.services.BrandService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/brands")
class BrandController(private val brandService: BrandService) {
    @GetMapping
    fun getAllCategories(): List<Brand> = brandService.getAllBrands()

    @PostMapping
    fun createCategory(@RequestBody brand: Brand): Brand = brandService.createBrand(brand)

    @PutMapping("{id}")
    fun updateCategory(@PathVariable id: Int, brand: Brand): Brand = brandService.updateBrand(id, brand)

    @DeleteMapping("{id}")
    fun deleteCategory(@PathVariable id: Int): Brand = brandService.deleteBrand(id)
}