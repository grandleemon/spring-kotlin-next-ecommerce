package com.ecommerce.molla.brands

import org.springframework.stereotype.Service

@Service
class BrandsService(private val brandsRepository: BrandsRepository) {
    fun getAllBrands(): List<Brand> = brandsRepository.findAll()

    fun createBrand(brand: Brand): Brand = brandsRepository.save(brand);

    fun updateBrand(id: Int, brand: Brand): Brand {
        val brandToUpdate = brandsRepository.findById(id).orElseThrow();

        brandToUpdate.name = brand.name
        brandToUpdate.slug = brand.slug

        brandsRepository.save(brandToUpdate)

        return brandToUpdate
    }

    fun deleteBrand(id: Int): Brand {
        val brandToDelete = brandsRepository.findById(id).orElseThrow();

        brandsRepository.deleteById(id);

        return brandToDelete;
    }
}