package com.yasu22go25.twitterclone.controller.dto.response

import com.yasu22go25.twitterclone.domain.model.User
import com.yasu22go25.twitterclone.domain.value.UserId
import java.util.*

data class UserResponse(
    val id: String,
    val screenName: String,
    val customUserId: String,
    val createAt: String,
    val email: String,
    val birthDay: String?,
    val iconUrl: String?,
    val headerUrl: String?,
    val bio: String?,
    val location: String?,
    val website: String?,
    val isPrivate: Boolean
) {
    constructor(domain: User): this(
        domain.id.value,
        domain.screenName,
        domain.customUserId,
        domain.createAt.toString(),
        domain.email,
        domain.birthDay.toString(),
        domain.iconUrl,
        domain.headerUrl,
        domain.bio,
        domain.location,
        domain.website,
        domain.isPrivate
    )
}
