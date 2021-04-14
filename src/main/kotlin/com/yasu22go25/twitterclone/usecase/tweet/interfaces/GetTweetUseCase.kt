package com.yasu22go25.twitterclone.usecase.tweet.interfaces

import com.yasu22go25.twitterclone.domain.model.Tweet

interface GetTweetUseCase {
    fun get(tweetId: String): Tweet?
}