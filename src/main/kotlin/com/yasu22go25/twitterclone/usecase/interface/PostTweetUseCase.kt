package com.yasu22go25.twitterclone.usecase.`interface`

import com.yasu22go25.twitterclone.domain.model.Tweet
import com.yasu22go25.twitterclone.usecase.dto.PostTweetUseCaseDto

interface PostTweetUseCase {
    fun postTweet(dto: PostTweetUseCaseDto, userId: String): Tweet
}