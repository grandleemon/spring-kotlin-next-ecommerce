package com.ecommerce.molla.products

import com.ecommerce.molla.brands.Brand
import com.ecommerce.molla.categories.Category
import com.ecommerce.molla.screenshots.Screenshot
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction
import org.springframework.web.multipart.MultipartFile
import javax.persistence.*

@Entity
data class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    var name: String,
    var price: Int,
    var sale_price: Int,
    var ratings: Int,
    var review: Int,
    var sold: Int,
    var stock: Int,
    var new: Boolean,
    var slug: String,
    var sex: String,
    val preview: String,

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    val screenshots: List<Screenshot>,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "product_category",
        joinColumns = [JoinColumn(name = "product_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    val categories: MutableSet<Category>,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "product_brand",
        joinColumns = [JoinColumn(name = "product_id")],
        inverseJoinColumns = [JoinColumn(name = "brand_id")]
    )
    val brands: MutableSet<Brand>
)