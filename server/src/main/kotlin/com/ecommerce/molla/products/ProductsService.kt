package com.ecommerce.molla.products

import com.ecommerce.molla.brands.Brand
import com.ecommerce.molla.categories.Category
import com.ecommerce.molla.brands.BrandsRepository
import com.ecommerce.molla.categories.CategoriesRepository
import com.ecommerce.molla.files.FileRepository
import com.ecommerce.molla.files.FileService
import com.google.gson.Gson
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.*

@Service
class ProductsService(
    private val productsRepository: ProductsRepository,
    private val categoriesRepository: CategoriesRepository,
    private val brandsRepository: BrandsRepository,
    private val fileService: FileService
    ) {

    fun getAllProducts(): ResponseEntity<List<Product>> {
        val products = productsRepository.findAll()

        if(products.isEmpty()) return ResponseEntity(HttpStatus.NO_CONTENT)

        return ResponseEntity(products, HttpStatus.OK)
    };

    fun createProduct(product: String, preview: MultipartFile): ResponseEntity<Product> {
        val gson = Gson();
        val parsedProduct: ProductDto = gson.fromJson(product, ProductDto::class.java)

        val newProduct = Product(
            name = parsedProduct.name,
            new = parsedProduct.new,
            brands = parsedProduct.brands,
            categories = parsedProduct.categories,
            price = parsedProduct.price,
            ratings = parsedProduct.ratings,
            review = parsedProduct.review,
            sale_price = parsedProduct.sale_price,
            sex = parsedProduct.sex,
            slug = parsedProduct.slug,
            sold = parsedProduct.sold,
            stock = parsedProduct.stock,
            preview = fileService.uploadImageToFileSystem(preview)
        )

        return ResponseEntity(productsRepository.save(newProduct), HttpStatus.OK)
    };

    fun addCategory(id: Int, category: Category): ResponseEntity<Product> {
        val product: Product = productsRepository.findById(id).orElseThrow{ RuntimeException("Not found Product with id = \"$id\"") }
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
        val product: Product = productsRepository.findById(id).orElseThrow{ RuntimeException("Not found Product with id = \"$id\"") }
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

    fun updateProduct(id: Int, product: Product): ResponseEntity<Product> {
        val productToUpdate = productsRepository.findById(id).orElseThrow{ RuntimeException("Not found Product with id = \"$id\"") }

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

        return ResponseEntity(productsRepository.save(productToUpdate), HttpStatus.OK)
    }

    fun deleteProduct(id: Int): ResponseEntity<HttpStatus> {
        productsRepository.deleteById(id)

        return ResponseEntity(HttpStatus.NO_CONTENT)
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