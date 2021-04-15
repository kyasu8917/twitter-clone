package com.yasu22go25.twitterclone.domain.service

class Base64Separator {
    // Pair(MimeType, Base64のデータ部分)
    fun separate(base64: String): Pair<String, String>? {
        if(!Base64Validator().validate(base64)) return null

        val mimeType = base64.substring(base64.indexOf(':') + 1, base64.indexOf(';'))
        val base64Data = base64.substring(base64.indexOf(',') + 1)

        return Pair(mimeType, base64Data)
    }
}