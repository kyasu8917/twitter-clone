package com.yasu22go25.twitterclone.domain.service

import org.springframework.stereotype.Component

@Component
class Base64Validator {

    fun validate(base64: String): Boolean {
        val regex = Regex("data:.+/.+;base64,.+")
        return regex.containsMatchIn(base64)
    }

}