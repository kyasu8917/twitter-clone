package com.yasu22go25.twitterclone.domain.value

import com.yasu22go25.twitterclone.domain.exception.DomainValidationError

data class Email(
    val value: String
) {
    init {
        if(!value.contains('@')) throw DomainValidationError("メールアドレスが不正です")
    }
}
