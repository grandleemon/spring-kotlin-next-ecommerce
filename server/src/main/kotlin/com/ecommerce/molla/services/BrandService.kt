package com.ecommerce.molla.services

import com.ecommerce.molla.models.Brand
import com.ecommerce.molla.repositories.BrandRepository
import org.springframework.stereotype.Service

@Service
class BrandService(private val brandRepository: BrandRepository) {
    fun getAllBrands(): List<Brand> = brandRepository.findAll()

    fun createBrand(brand: Brand): Brand = brandRepository.save(brand);

    fun updateBrand(id: Int, brand: Brand): Brand {
        val brandToUpdate = brandRepository.findById(id).orElseThrow();

        brandToUpdate.name = brand.name
        brandToUpdate.slug = brand.slug

        brandRepository.save(brandToUpdate)

        return brandToUpdate
    }

    fun deleteBrand(id: Int): Brand {
        val brandToDelete = brandRepository.findById(id).orElseThrow();

        brandRepository.deleteById(id);

        return brandToDelete;
    }
}