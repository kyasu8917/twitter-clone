package com.yasu22go25.twitterclone.domain.model

import com.yasu22go25.twitterclone.domain.exception.DomainValidationError
import com.yasu22go25.twitterclone.domain.service.Base64Separator
import com.yasu22go25.twitterclone.domain.service.Base64Validator
import com.yasu22go25.twitterclone.domain.value.MimeType

class Media(
    val type: MimeType,
    val base64EncodedData: String
) {

    companion object {
        fun new(base64: String): Media {
            val (mimeType, base64Data) = Base64Separator().separate(base64)
                ?: throw DomainValidationError("base64フォーマットが不正です")
            return Media(MimeType.new(mimeType), base64Data)
        }
    }

}