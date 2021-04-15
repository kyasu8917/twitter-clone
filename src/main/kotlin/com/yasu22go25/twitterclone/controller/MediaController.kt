package com.yasu22go25.twitterclone.controller

import com.yasu22go25.twitterclone.controller.dto.request.PostMediaRequestParameter
import com.yasu22go25.twitterclone.domain.model.Media
import com.yasu22go25.twitterclone.infra.repository.interfaces.FileUploader
import com.yasu22go25.twitterclone.usecase.media.dto.UploadMediaDto
import com.yasu22go25.twitterclone.usecase.media.interfaces.UploadMediaUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/media")
class MediaController(
    val uploadMediaUseCase: UploadMediaUseCase
) {

    // 画像を保存して、保存先URLを返す
    @PostMapping
    fun upload(@RequestBody parameter: PostMediaRequestParameter): String {
        val dto = UploadMediaDto(
            base64 = parameter.base64
        )
        return uploadMediaUseCase.upload(dto)
    }
}