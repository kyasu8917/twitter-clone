package com.yasu22go25.twitterclone.domain.model

import com.yasu22go25.twitterclone.domain.value.UserId
import java.util.*

class Tweet(
    val id: String,
    val userId: UserId,
    val createAt: Date,
    val text: String,
    val favorites: List<UserId>,
    val retweeted: List<UserId>
)