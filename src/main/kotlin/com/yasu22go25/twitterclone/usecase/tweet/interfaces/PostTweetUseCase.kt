package com.yasu22go25.twitterclone.usecase.tweet.interfaces

import com.yasu22go25.twitterclone.domain.model.Tweet
import com.yasu22go25.twitterclone.usecase.tweet.dto.PostTweetUseCaseDto

interface PostTweetUseCase {
    fun postTweet(dto: PostTweetUseCaseDto, userId: String): Tweet
}