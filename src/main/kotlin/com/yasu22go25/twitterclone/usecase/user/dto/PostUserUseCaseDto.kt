package com.yasu22go25.twitterclone.usecase.user.dto

import java.util.*

data class PostUserUseCaseDto(
    val screenName: String,
    val customUserId: String,
    val createAt: Date,
    val email: String,
    val birthDay: Date?,
    val iconUrl: String?,
    val headerUrl: String?,
    val bio: String?,
    val location: String?,
    val website: String?,
    val isPrivate: Boolean
)
