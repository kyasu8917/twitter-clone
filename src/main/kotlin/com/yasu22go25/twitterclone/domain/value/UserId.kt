package com.yasu22go25.twitterclone.domain.value

import java.util.*

data class UserId(
    val value: String
) {
    constructor(): this(UUID.randomUUID().toString())
}