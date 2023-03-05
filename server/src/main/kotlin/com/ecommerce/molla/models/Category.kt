package com.ecommerce.molla.models

import javax.persistence.*

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
    var name: String,
    var slug: String
)