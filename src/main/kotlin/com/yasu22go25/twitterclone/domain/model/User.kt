package com.yasu22go25.twitterclone.domain.model

import com.yasu22go25.twitterclone.domain.value.Email
import com.yasu22go25.twitterclone.domain.value.UserId
import java.util.*

class User(
    val id: UserId,
    val screenName: String,
    val customUserId: String,
    val createAt: Date,
    val email: Email,
    val birthDay: Date?,
    val iconUrl: String?,
    val headerUrl: String?,
    val bio: String?,
    val location: String?,
    val website: String?,
    val isPrivate: Boolean
) {}