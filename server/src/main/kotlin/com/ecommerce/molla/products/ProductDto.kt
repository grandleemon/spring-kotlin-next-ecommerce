package com.ecommerce.molla.products

import com.ecommerce.molla.brands.Brand
import com.ecommerce.molla.categories.Category
import org.springframework.web.multipart.MultipartFile

data class ProductDto(
    val name: String,
    val price: Int,
    val sale_price: Int,
    val ratings: Int,
    val review: Int,
    val sold: Int,
    val stock: Int,
    val new: Boolean,
    val slug: String,
    val sex: String,
    val categories: MutableSet<Category>,
    val brands: MutableSet<Brand>
)