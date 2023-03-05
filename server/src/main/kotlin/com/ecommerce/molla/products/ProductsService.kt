package com.ecommerce.molla.products

import com.ecommerce.molla.brands.Brand
import com.ecommerce.molla.categories.Category
import com.ecommerce.molla.brands.BrandsRepository
import com.ecommerce.molla.categories.CategoriesRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductsService(
    private val productsRepository: ProductsRepository,
    private val categoriesRepository: CategoriesRepository,
    private val brandsRepository: BrandsRepository
    ) {
    fun getAllProducts(): List<Product> = productsRepository.findAll();

    fun createProduct(product: Product): Product = productsRepository.save(product);

    fun addCategory(id: Int, category: Category): ResponseEntity<Product> {
        val product: Product = productsRepository.findById(id).orElseThrow()
        val categoryToFind: Optional<Category> = categoriesRepository.findById(category.id)
        return if(categoryToFind.isPresent) {
            product.categories.add(categoryToFind.get())
            productsRepository.save(product)
            ResponseEntity<Product>(product, HttpStatus.CREATED)
        } else {
            categoriesRepository.save(category)
            product.categories.add(category)
            productsRepository.save(product)
            ResponseEntity<Product>(product, HttpStatus.CREATED)
        }
    }

    fun addBrand(id: Int, brand: Brand): ResponseEntity<Product> {
        val product: Product = productsRepository.findById(id).orElseThrow()
        val brandToFind: Optional<Category> = categoriesRepository.findById(brand.id)
        return if(brandToFind.isPresent) {
            product.categories.add(brandToFind.get())
            productsRepository.save(product)
            ResponseEntity<Product>(product, HttpStatus.CREATED)
        } else {
            brandsRepository.save(brand)
            product.brands.add(brand)
            productsRepository.save(product)
            ResponseEntity<Product>(product, HttpStatus.CREATED)
        }
    }

    fun updateProduct(id: Int, product: Product): Product {
        val productToUpdate = productsRepository.findById(id).orElseThrow()

        productToUpdate.name = product.name
        productToUpdate.new = product.new
        productToUpdate.price = product.price
        productToUpdate.sex = product.sex
        productToUpdate.ratings = product.ratings
        productToUpdate.review = product.review
        productToUpdate.stock = product.stock
        productToUpdate.sold = product.sold
        productToUpdate.slug = product.slug
        productToUpdate.sale_price = product.sale_price

        productsRepository.save(productToUpdate)

        return productToUpdate
    }

    fun deleteProduct(id: Int): Product {
        val productToDelete = productsRepository.findById(id).orElseThrow()

        productsRepository.deleteById(id)

        return productToDelete
    }

    fun deleteCategory(id: Int, categories: Category): ResponseEntity<Product> {
        val product = productsRepository.findById(id).orElseThrow()

        product.categories.remove(categories)
        productsRepository.save(product)

        return ResponseEntity(product, HttpStatus.OK)
    }

    fun deleteBrand(id: Int, brands: Brand): ResponseEntity<Product> {
        val product = productsRepository.findById(id).orElseThrow()

        product.brands.remove(brands)
        productsRepository.save(product)

        return ResponseEntity(product, HttpStatus.OK)
    }
}