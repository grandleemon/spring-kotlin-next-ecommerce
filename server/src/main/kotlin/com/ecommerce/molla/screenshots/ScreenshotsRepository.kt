package com.ecommerce.molla.screenshots

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ScreenshotsRepository : JpaRepository<Screenshot, Int> {
    fun findByName(fileName: String?): Optional<Screenshot>
}