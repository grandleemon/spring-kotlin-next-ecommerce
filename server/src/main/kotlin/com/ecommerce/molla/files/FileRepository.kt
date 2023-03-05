package com.ecommerce.molla.files

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface FileRepository : JpaRepository<UploadFile, Int> {
    fun findByName(fileName: String): Optional<UploadFile>
}