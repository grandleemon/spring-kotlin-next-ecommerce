package com.ecommerce.molla.files

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.isRegularFile

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
    private final val fileSeparator: String = FileSystems.getDefault().separator
    private final val defaultUploadsFolderPath = "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator
    private final val uploadsFolderPath = Paths.get("src/main/resources/static/images")

    fun uploadImageToFileSystem(file: MultipartFile): String {
//        val filePath = uploadsFolderPath + file.originalFilename
        val uploadedTargetFilePath = uploadsFolderPath.resolve(file.originalFilename);

        fileRepository.save(
            UploadFile(
                name = file.originalFilename,
                type = file.contentType,
                path = "static" + fileSeparator + "images" + fileSeparator + file.originalFilename
            )
        )

        Files.copy(file.inputStream, uploadedTargetFilePath)
        uploadedTargetFilePath.isRegularFile()

        return "File uploaded successfully: $uploadedTargetFilePath"
    }

    fun downloadFileFromFileSystem(fileName: String): ByteArray {
        val fileData = fileRepository.findByName(fileName)

        val filePath = fileData.get().path

        return Files.readAllBytes(File(defaultUploadsFolderPath + filePath).toPath())
    }
}