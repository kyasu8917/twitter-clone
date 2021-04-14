package com.yasu22go25.twitterclone.domain.model

import com.yasu22go25.twitterclone.domain.exception.DomainValidationError
import com.yasu22go25.twitterclone.domain.value.UserId
import java.util.*

class Tweet(
    val id: String,
    val userId: UserId,
    val createAt: Date,
    val text: String,
    val favorites: List<UserId>,
    val retweeted: List<UserId>
) {
    init {
        if(text.length > 140) throw DomainValidationError("ツイートの文字数は140字以下である必要があります。")
    }
}