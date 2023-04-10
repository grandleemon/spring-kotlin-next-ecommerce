package com.ecommerce.molla.screenshots

import com.ecommerce.molla.products.Product
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
data class Screenshot(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val name: String?,
    val image: String
)
