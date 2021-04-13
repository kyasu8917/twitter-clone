package com.yasu22go25.twitterclone.controller.dto.response

data class PostTweetResponse(
    val id: String,
    val userId: String,
    val createAt: String,
    val text: String,
    val favorites: List<String>,
    val retweeted: List<String>
)
