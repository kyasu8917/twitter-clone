package com.yasu22go25.twitterclone.infra.repository

import com.yasu22go25.twitterclone.domain.model.Media
import com.yasu22go25.twitterclone.infra.repository.interfaces.FileUploader
import org.springframework.stereotype.Repository

@Repository
class FileUploaderImpl: FileUploader {
    override fun upload(media: Media): String {
        return "https://media/uploaded/url"
    }
}