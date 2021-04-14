package com.yasu22go25.twitterclone.usecase.tweet.dto

import java.util.*

data class PostTweetUseCaseDto(
    val userId: String,
    val text: String,
    val createAt: Date
)
