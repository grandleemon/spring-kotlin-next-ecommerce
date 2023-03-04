package com.ecommerce.molla.controllers

import com.ecommerce.molla.models.Brand
import com.ecommerce.molla.services.BrandService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/brands")
class BrandController(private val brandService: BrandService) {
    @GetMapping
    fun getAllBrands(): List<Brand> = brandService.getAllBrands()

    @PostMapping
    fun createBrand(@RequestBody brand: Brand): Brand = brandService.createBrand(brand)

    @PutMapping("{id}")
    fun updateBrand(@PathVariable id: Int, @RequestBody brand: Brand): Brand = brandService.updateBrand(id, brand)

    @DeleteMapping("{id}")
    fun deleteBrand(@PathVariable id: Int): Brand = brandService.deleteBrand(id)
}