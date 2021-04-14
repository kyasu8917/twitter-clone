package com.yasu22go25.twitterclone.controller

import com.yasu22go25.twitterclone.controller.dto.request.PostTweetRequestParameter
import com.yasu22go25.twitterclone.controller.dto.response.TweetResponse
import com.yasu22go25.twitterclone.controller.exception.NotFoundException
import com.yasu22go25.twitterclone.usecase.`interface`.GetTweetUseCase
import com.yasu22go25.twitterclone.usecase.`interface`.PostTweetUseCase
import com.yasu22go25.twitterclone.usecase.dto.PostTweetUseCaseDto
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(path = ["/{userId}/tweet"])
class TweetController(
    val postTweetUseCase: PostTweetUseCase,
    val getTweetUseCase: GetTweetUseCase
) {

    @GetMapping(path = ["/{tweetId}"])
    fun get(@PathVariable("tweetId") tweetId: String): TweetResponse {
        val tweet = getTweetUseCase.get(tweetId) ?: throw NotFoundException()

        return TweetResponse(
                id = tweet.id,
                userId = tweet.userId.value,
                createAt = tweet.createAt.toString(),
                text = tweet.text,
                favorites = tweet.favorites.map { it.value },
                retweeted = tweet.retweeted.map { it.value }
        )

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun post(@RequestBody parameters: PostTweetRequestParameter, @PathVariable("userId") userId: String): TweetResponse {
        val dto = PostTweetUseCaseDto(
            userId = userId,
            text = parameters.text,
            createAt = parameters.createAt
        )

        val domain = postTweetUseCase.postTweet(dto, userId)

        return TweetResponse(
            id = domain.id,
            userId = domain.userId.value,
            createAt = domain.createAt.toString(),
            text = domain.text,
            favorites = domain.favorites.map { it.value },
            retweeted = domain.retweeted.map { it.value }
        )

    }

}