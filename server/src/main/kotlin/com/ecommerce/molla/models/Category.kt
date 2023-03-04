package com.ecommerce.molla.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Category(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int,
    var name: String,
    var slug: String
)