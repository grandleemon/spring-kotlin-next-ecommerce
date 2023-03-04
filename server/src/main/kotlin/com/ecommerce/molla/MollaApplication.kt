package com.ecommerce.molla

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MollaApplication

fun main(args: Array<String>) {
	runApplication<MollaApplication>(*args)
	println("server started");
}
