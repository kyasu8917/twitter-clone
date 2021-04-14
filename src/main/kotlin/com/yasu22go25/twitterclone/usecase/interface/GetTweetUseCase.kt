package com.yasu22go25.twitterclone.usecase.`interface`

import com.yasu22go25.twitterclone.domain.model.Tweet

interface GetTweetUseCase {
    fun get(tweetId: String): Tweet?
}