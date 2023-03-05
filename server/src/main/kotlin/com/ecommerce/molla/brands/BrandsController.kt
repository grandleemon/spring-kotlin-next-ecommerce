package com.ecommerce.molla.brands

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/brands")
class BrandsController(private val brandsService: BrandsService) {
    @GetMapping
    fun getAllBrands() = brandsService.getAllBrands()

    @PostMapping
    fun createBrand(@RequestBody brand: Brand) = brandsService.createBrand(brand)

    @PutMapping("{id}")
    fun updateBrand(@PathVariable id: Int, @RequestBody brand: Brand) = brandsService.updateBrand(id, brand)

    @DeleteMapping("{id}")
    fun deleteBrand(@PathVariable id: Int) = brandsService.deleteBrand(id)
}