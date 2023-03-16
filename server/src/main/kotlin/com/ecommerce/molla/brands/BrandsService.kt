package com.ecommerce.molla.brands

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class BrandsService(private val brandsRepository: BrandsRepository) {
    fun getAllBrands(): ResponseEntity<List<Brand>> {
        val brands = brandsRepository.findAll();

        if(brands.isEmpty()) return ResponseEntity(HttpStatus.NO_CONTENT)

        return ResponseEntity(brands, HttpStatus.OK)
    }

    fun createBrand(brand: Brand): ResponseEntity<Brand> {
        return ResponseEntity(brandsRepository.save(brand), HttpStatus.OK)
    }

    fun updateBrand(id: Int, brand: Brand): ResponseEntity<Brand> {
        val brandToUpdate = brandsRepository.findById(id).orElseThrow{ RuntimeException("Not found Brand with id = \"$id\"") }

        brandToUpdate.name = brand.name
        brandToUpdate.slug = brand.slug

        return ResponseEntity(brandsRepository.save(brandToUpdate), HttpStatus.OK)
    }

    fun deleteBrand(id: Int): ResponseEntity<HttpStatus> {
        brandsRepository.deleteById(id);

        return ResponseEntity(HttpStatus.OK);
    }
}