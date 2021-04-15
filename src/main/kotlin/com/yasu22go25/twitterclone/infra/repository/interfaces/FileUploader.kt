package com.yasu22go25.twitterclone.infra.repository.interfaces

import com.yasu22go25.twitterclone.domain.model.Media

interface FileUploader {
    fun upload(media: Media): String
}