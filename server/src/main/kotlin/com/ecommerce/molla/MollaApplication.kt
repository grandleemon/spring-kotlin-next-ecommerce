package com.ecommerce.molla

import com.ecommerce.molla.files.FileService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//@SpringBootApplication
//class MollaApplication : CommandLineRunner {
//
//	@Autowired
//	lateinit var uploadfileService: FileService
//
//	override fun run(vararg args: String?) {
//		uploadfileService.init()
//			.onFailure { throw RuntimeException("System cannot start up because no uploads folder is set up") }
//	}
//}

@SpringBootApplication
class MollaApplication

fun main(args: Array<String>) {
	runApplication<MollaApplication>(*args)
}
