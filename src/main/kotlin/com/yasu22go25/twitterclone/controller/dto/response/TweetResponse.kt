package com.yasu22go25.twitterclone.controller.dto.response

import com.yasu22go25.twitterclone.domain.model.Tweet

data class TweetResponse(
    val id: String,
    val userId: String,
    val createAt: String,
    val text: String,
    val favorites: List<String>,
    val retweeted: List<String>
) {

    constructor(domain: Tweet) : this(
        domain.id,
        domain.userId.value,
        domain.createAt.toString(),
        domain.text,
        domain.favorites.map { it.value },
        domain.retweeted.map { it.value }
    )

}
