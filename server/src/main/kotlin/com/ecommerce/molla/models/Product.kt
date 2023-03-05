package com.ecommerce.molla.models

import javax.persistence.*

@Entity
data class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
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

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "product_category",
        joinColumns = [JoinColumn(name = "product_id")],
        inverseJoinColumns = [JoinColumn(name = "category_id")]
    )
    val categories: MutableSet<Category>
)