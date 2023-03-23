package com.ecommerce.molla.screenshots

import com.ecommerce.molla.products.Product
import javax.persistence.*

@Entity
data class Screenshot(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val name: String?,
    val image: String,

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    val related_product: Product? = null
)
