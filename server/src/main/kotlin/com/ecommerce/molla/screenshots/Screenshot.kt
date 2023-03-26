package com.ecommerce.molla.screenshots

import com.ecommerce.molla.products.Product
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
@Table(name = "image2")
data class Screenshot(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,
    val name: String?,
    val image: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    val related_product: Product? = null
)
