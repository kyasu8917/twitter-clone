package com.yasu22go25.twitterclone.usecase.media.interfaces

import com.yasu22go25.twitterclone.usecase.media.dto.UploadMediaDto

interface UploadMediaUseCase {
    fun upload(dto: UploadMediaDto): String
}