package com.ecommerce.molla.files

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.isRegularFile

@Service
class FileService(private val fileRepository: FileRepository) {
    private final val fileSeparator: String = FileSystems.getDefault().separator
    private final val defaultUploadsFolderPath = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
    private final val uploadsFolderPath = Paths.get("src/main/resources/static/images")

    fun uploadImageToFileSystem(file: MultipartFile): String {
        val uploadedTargetFilePath = uploadsFolderPath.resolve(file.originalFilename);

        fileRepository.save(
            File(
                name = file.originalFilename,
                type = file.contentType,
                path = "static" + fileSeparator + "images" + fileSeparator + file.originalFilename
            )
        )

        Files.copy(file.inputStream, uploadedTargetFilePath)
        uploadedTargetFilePath.isRegularFile()

        return "static/images/" + file.originalFilename
    }

    fun downloadFileFromFileSystem(fileName: String): ByteArray {
        val fileData = fileRepository.findByName(fileName)

        val filePath = fileData.get().path

        return Files.readAllBytes(File(defaultUploadsFolderPath + filePath).toPath())
    }
}