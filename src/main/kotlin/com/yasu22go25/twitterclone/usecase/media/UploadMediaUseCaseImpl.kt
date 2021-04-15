package com.yasu22go25.twitterclone.usecase.media

import com.yasu22go25.twitterclone.domain.model.Media
import com.yasu22go25.twitterclone.infra.repository.interfaces.FileUploader
import com.yasu22go25.twitterclone.usecase.media.dto.UploadMediaDto
import com.yasu22go25.twitterclone.usecase.media.interfaces.UploadMediaUseCase
import org.springframework.stereotype.Component

@Component
class UploadMediaUseCaseImpl(
    val fileUploader: FileUploader
): UploadMediaUseCase {
    override fun upload(dto: UploadMediaDto): String {
        return fileUploader.upload(Media.new(dto.base64))
    }
}