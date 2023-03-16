package com.ecommerce.molla.files

import javax.persistence.*

@Entity
data class File(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = true)
    val id: Int? = null,
    val name: String?,
    val type: String?,
    val path: String
)
