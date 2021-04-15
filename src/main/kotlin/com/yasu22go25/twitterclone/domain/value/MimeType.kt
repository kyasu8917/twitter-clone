package com.yasu22go25.twitterclone.domain.value

import com.yasu22go25.twitterclone.domain.exception.DomainValidationError

enum class MimeType(val value: String) {
    JPEG("image/jpeg"),
    PNG("image/png"),
    GIF("image/gif"),
    BMP("image/bmp"),
    MP3("audio/mpeg"),
    MP4("video/mp4"),
    MPEG("video/mpeg");

    companion object {
        fun new(mimeTypeValue: String): MimeType {
            when (mimeTypeValue) {
                JPEG.value -> {
                    return JPEG
                }
                PNG.value -> {
                    return PNG
                }
                GIF.value -> {
                    return GIF
                }
                BMP.value -> {
                    return BMP
                }
                MP3.value -> {
                    return MP3
                }
                MP4.value -> {
                    return MP4
                }
                MPEG.value -> {
                    return MPEG
                }
                else -> {
                    throw DomainValidationError("サポートしていないMimeTypeが指定されています")
                }
            }
        }
    }
}