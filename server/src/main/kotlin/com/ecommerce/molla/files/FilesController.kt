package com.ecommerce.molla.files

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1/files")
class FilesController(private val fileService: FileService) {

//    val log = KotlinLogging.logger {}
//
//    @PostMapping("/upload")
//    fun uploadFile(@RequestParam("file") file: MultipartFile): ResponseEntity<Response> {
//        log.info { "Requested uploading file: ${file.originalFilename}" }
//
//        return when(fileService.upload(file).getOrDefault(false)) {
//            true -> ResponseEntity.status(HttpStatus.OK).body(
//                Response(message = "File upload successfully: ${file.originalFilename}"))
//            else -> ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
//                Response(message = "Error when trying to upload the file: ${file.originalFilename} !"))
//        }
//    }

    @PostMapping("/upload")
    fun uploadFileToFileSystem(@RequestParam("image") file: MultipartFile): ResponseEntity<String> {
        val uploadImage = fileService.uploadImageToFileSystem(file)

        return ResponseEntity(uploadImage, HttpStatus.OK)
    }

    @GetMapping("/{fileName}")
    fun downloadImageFromFileSystem(@PathVariable("fileName") fileName: String): ResponseEntity<ByteArray> {
        val imageData = fileService.downloadFileFromFileSystem(fileName)

        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.valueOf("image/png"))
            .body(imageData)
    }
}