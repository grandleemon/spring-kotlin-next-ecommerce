package com.ecommerce.molla.files

import java.nio.file.Path
import javax.persistence.*

@Entity
data class UploadFile(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = true)
    val id: Int? = null,
    val name: String?,
    val type: String?,
    val path: String
)
