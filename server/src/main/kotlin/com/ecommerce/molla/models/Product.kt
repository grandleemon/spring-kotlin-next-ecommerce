package com.ecommerce.molla.models

import javax.persistence.*

@Entity
data class Product (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
    val name: String,
    val price: Int,
    val sale_price: Int,
    val ratings: Int,
    val review: Int,
    val sold: Int,
    val stock: Int,
    val new: Boolean,
    val slug: String,
    val sex: String
)