package com.ecommerce.molla.models

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Brand(
    @Id
    val id: Int,
    val name: String,
    val slug: String
)