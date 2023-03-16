package com.ecommerce.molla.files

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
@RequestMapping("/api/v1/static/images")
class FilesController(private val fileService: FileService) {

    @PostMapping()
    fun uploadFileToFileSystem(@RequestParam("image") file: MultipartFile) = fileService.uploadImageToFileSystem(file)

    @GetMapping("/{fileName}")
    fun downloadImageFromFileSystem(@PathVariable("fileName") fileName: String): ResponseEntity<ByteArray> {
        val imageData = fileService.downloadFileFromFileSystem(fileName)

        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(imageData)
    }
}