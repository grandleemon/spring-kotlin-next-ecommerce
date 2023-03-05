package com.ecommerce.molla.files

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.util.Optional

@Service
class FileService(private val fileRepository: FileRepository) {
//    val log = KotlinLogging.logger {}
//
//    val uploadsFolderPath: Path = Paths.get("src/main/resources/uploads")
//
//    fun init(): Result<Path> =
//        runCatching {
//            Files.createDirectories(uploadsFolderPath)
//        }
//            .onFailure { log.error { "Error creating uploads folder: ${it.message}" } }
//            .onSuccess { log.info { "Created folder uploads successfully: ${it.fileName}" } }
//
//    fun upload(file: MultipartFile): Result<Boolean> =
//        runCatching {
//            log.debug { "uploading file ${file.originalFilename} to ${uploadsFolderPath.fileName} folder"}
//
//            val uploadedTargetFilePath = uploadsFolderPath.resolve(file.originalFilename);
//            Files.copy(file.inputStream, uploadedTargetFilePath)
//            uploadedTargetFilePath.isRegularFile()
//        }.onFailure {
//            log.warn { "Error uploading file ${file.originalFilename} reason: ${it.javaClass}" }}

    private val uploadsFolderPath = "D:\\Projects\\Molla - ecommerce\\server\\src\\main\\resources\\uploads\\"

    fun uploadImageToFileSystem(file: MultipartFile): String {
        val filePath = uploadsFolderPath + file.originalFilename

        fileRepository.save(
            UploadFile(
                name = file.originalFilename,
                type = file.contentType,
                path = filePath
            )
        )

        file.transferTo(File(filePath))

        return "File uploaded successfully: $filePath"
    }

    fun downloadFileFromFileSystem(fileName: String): ByteArray {
        val fileData = fileRepository.findByName(fileName)

        val filePath = fileData.get().path
        val images = Files.readAllBytes(File(filePath).toPath())

        return images
    }
}