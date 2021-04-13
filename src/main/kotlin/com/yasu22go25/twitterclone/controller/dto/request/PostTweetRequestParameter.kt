package com.yasu22go25.twitterclone.controller.dto.request

import java.util.*

data class PostTweetRequestParameter(
    val text: String,
    val createAt: Date
)