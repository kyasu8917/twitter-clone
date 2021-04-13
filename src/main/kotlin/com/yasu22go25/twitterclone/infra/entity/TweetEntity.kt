package com.yasu22go25.twitterclone.infra.entity

import com.yasu22go25.twitterclone.domain.value.UserId
import java.util.*

data class TweetEntity(
    val id: String,
    val userId: String,
    val createAt: Date,
    val text: String,
    val favorites: List<String>,
    val retweeted: List<String>
)
