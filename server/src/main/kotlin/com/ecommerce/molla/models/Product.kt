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
    var sex: String
)