package com.ecommerce.molla.screenshots

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.nio.file.FileSystems
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.io.path.isRegularFile

@Service
class ScreenshotsService(private val screenshotsRepository: ScreenshotsRepository) {
    private final val fileSeparator: String = FileSystems.getDefault().separator
    private final val uploadsFolderPath = Paths.get("src/main/resources/static/images")

    fun uploadScreenshot(screenshots: List<MultipartFile>): List<Screenshot> {
        val screenshotsLinks = ArrayList<Screenshot>()

        for (screenshot in screenshots) {
            val uploadedTargetFilePath = uploadsFolderPath.resolve(screenshot.originalFilename)

            screenshotsRepository.save(
                Screenshot(
                    name = screenshot.originalFilename,
                    image = "static" + fileSeparator + "images" + fileSeparator + screenshot.originalFilename
                )
            )

            Files.copy(screenshot.inputStream, uploadedTargetFilePath)
            uploadedTargetFilePath.isRegularFile()

            val thisScreenshot = screenshotsRepository.findByName(screenshot.originalFilename).orElseThrow()
            screenshotsLinks.add(thisScreenshot)
        }

        return screenshotsLinks
    }
}