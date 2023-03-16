import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.9"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	id("org.jetbrains.kotlin.plugin.jpa") version "1.8.20-Beta"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.ecommerce"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-web:2.7.9")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.9")
	implementation("org.postgresql:postgresql:42.5.4")
	implementation("io.github.microutils:kotlin-logging-jvm:2.0.11")
	implementation("com.google.code.gson:gson:2.10.1")
	implementation("org.springdoc:springdoc-openapi-ui:1.6.9")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("ch.qos.logback:logback-classic:1.2.11")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
